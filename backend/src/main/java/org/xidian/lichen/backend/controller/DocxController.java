package org.xidian.lichen.backend.controller;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.xidian.lichen.backend.entity.Province;
import org.xidian.lichen.backend.service.DocxService;
import org.xidian.lichen.backend.service.ProvinceService;
import org.xidian.lichen.backend.service.TableService;
import org.xidian.lichen.backend.util.Docx2PdfConvertor;
import org.xidian.lichen.backend.util.MicrosoftDocxGenerator;

import java.io.*;
import java.util.List;

@RestController
@RequestMapping("/docx")
public class DocxController {
    @Autowired
    private DocxService docxService;

    @Autowired
    private TableService tableService;
    @Autowired
    private ProvinceService provinceService;

    @GetMapping("/generate")
    public String generate(@RequestParam("name") String name,
                           @RequestParam("year") String year,
                           @RequestParam("isMajor") boolean isMajor,
                           @RequestParam("isRank") boolean isRank,
                           @RequestParam("isIndex") boolean isIndex,
                           @RequestParam("isStudent") boolean isStudent,
                           @RequestParam("isThousandIndex") boolean isThousandIndex,
                           @RequestParam("isGPT") boolean isGPT) {
        String downloadPath = "/Users/lichen/Downloads/"+name+".docx";
        MicrosoftDocxGenerator generator = new MicrosoftDocxGenerator(downloadPath);

        generator.addTitle(name + year + "年招生数据分析报告");

        // 1m14.70s
        if (isStudent) {
            docxService.generateStudentMajorRatePara(generator, name, year);
        }

        if (isMajor) {
            docxService.generateMajorPara(generator, name, year); // ～30s
        }

        if (isRank) {
            docxService.generateSchoolRankPara(generator, name, year); // ~45s
        }

        if (isIndex) {
            docxService.generateMajorIndexPara(generator, name, "计算机", isGPT); // ~10s ~35s
            docxService.generateMajorIndexPara(generator, name, "软件", isGPT); // ~10s
            docxService.generateMajorIndexPara(generator, name, "物理", isGPT); // ~10s
        }

        if (isThousandIndex) {
            docxService.generateMajorThousandIndexPara(generator, name, "计算机", isGPT); // ~10s ~35s
            docxService.generateMajorThousandIndexPara(generator, name, "软件", isGPT); // ~10s
            docxService.generateMajorThousandIndexPara(generator, name, "物理", isGPT); // ~10s
        }

        try {
            System.out.println("Start saving files...");
            generator.save();

            String resultPath = "/Users/lichen/IdeaProjects/Thesis/frontend/src/static/result.docx";
            String resultPDFPath = "/Users/lichen/IdeaProjects/Thesis/frontend/src/static/result.pdf";

            InputStream docFile = new FileInputStream(new File(downloadPath));
            XWPFDocument document = new XWPFDocument(docFile);
            OutputStream outFile = new FileOutputStream(new File(resultPath));
            document.write(outFile);

            Docx2PdfConvertor.convert2PDF(downloadPath, resultPDFPath);

            System.out.println("All saved!");
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }

        return "ok";
    }

    @GetMapping("/converter")
    public String converter(@RequestParam("name") String name) {
        String docxFilePath = name + ".docx";
        String pdfFilePath = name + ".pdf";

        try {
            Docx2PdfConvertor.convert2PDF(docxFilePath, pdfFilePath);
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }

        return "ok";
    }
}