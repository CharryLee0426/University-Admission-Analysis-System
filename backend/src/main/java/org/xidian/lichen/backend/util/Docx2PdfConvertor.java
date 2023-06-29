package org.xidian.lichen.backend.util;

import com.convertapi.client.Config;
import com.convertapi.client.ConvertApi;
import com.convertapi.client.Param;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.BaseFont;
import fr.opensagres.poi.xwpf.converter.pdf.PdfOptions;
import fr.opensagres.xdocreport.converter.ConverterRegistry;
import fr.opensagres.xdocreport.converter.ConverterTypeTo;
import fr.opensagres.xdocreport.converter.IConverter;
import fr.opensagres.xdocreport.converter.Options;
import fr.opensagres.xdocreport.core.document.DocumentKind;
import fr.opensagres.xdocreport.itext.extension.font.IFontProvider;
import fr.opensagres.xdocreport.itext.extension.font.ITextFontRegistry;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFStyles;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPageSz;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr;

import java.awt.*;
import java.io.*;
import java.math.BigInteger;
import java.nio.file.Paths;

public class Docx2PdfConvertor {
    public static void convertToPDF(String docxFilePath, String pdfFilePath) {
        try {
            InputStream docFile = new FileInputStream(new File(docxFilePath));

            XWPFDocument document = new XWPFDocument(docFile);

            // there must be a styles document, even if it is empty
            XWPFStyles styles = document.createStyles();

            // there must be section properties for the page having at least the page size set
            CTSectPr sectPr = document.getDocument().getBody().addNewSectPr();
            CTPageSz pageSz = sectPr.addNewPgSz();
            pageSz.setW(BigInteger.valueOf(18000)); //12240 Twips = 12240/20 = 612 pt = 612/72 = 8.5"
            pageSz.setH(BigInteger.valueOf(15840)); //15840 Twips = 15840/20 = 792 pt = 792/72 = 11"

            ByteArrayOutputStream out = new ByteArrayOutputStream();
            document.write(out);
            document.close();

            document = new XWPFDocument(new ByteArrayInputStream(out.toByteArray()));

            Options options = Options.getFrom(DocumentKind.DOCX).to(ConverterTypeTo.PDF);

            PdfOptions pdfOptions = PdfOptions.create();

            pdfOptions.fontProvider(new IFontProvider() {
                @Override
                public Font getFont(String familyName, String encoding, float size, int style, Color color) {
                    try {
                        BaseFont bfChinese = BaseFont.createFont("/System/Library/Fonts/Supplemental/Arial Unicode.ttf",
                                BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
//                        BaseFont bfChinese = BaseFont.createFont("static/AdobeSongStd-Light.otf",
//                                BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
                        Font fontChinese = new Font(bfChinese, size, style, color);

                        if (familyName != null) {
                            fontChinese.setFamily(familyName);
                        }

                        return fontChinese;
                    } catch (Exception e) {
                        System.out.println(e.getLocalizedMessage());
                        return ITextFontRegistry.getRegistry().getFont(familyName, encoding, size, style, color);
                    }
                }
            });

            options.subOptions(pdfOptions);

            IConverter converter = ConverterRegistry.getRegistry().getConverter(options);

            InputStream docxin = new ByteArrayInputStream(out.toByteArray());
            OutputStream out2 = new FileOutputStream(new File(pdfFilePath));

            converter.convert(docxin, out2, options);
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }

    public static void convert2PDF(String docxFilePath, String pdfFilePath) throws Exception {
        Config.setDefaultSecret("Jjcyo0J6CFkxgBsp");

        ConvertApi.convert("docx", "pdf",
                new Param("file", Paths.get(docxFilePath))
        ).get().saveFile(Paths.get(pdfFilePath)).get();
    }
}
