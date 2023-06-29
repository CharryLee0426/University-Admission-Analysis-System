package org.xidian.lichen.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.xidian.lichen.backend.entity.Province;
import org.xidian.lichen.backend.service.ProvinceService;

import java.util.List;

@RestController
@RequestMapping("/province")
public class ProvinceController {
    @Autowired
    private ProvinceService provinceService;

    @GetMapping("/list")
    public List<Province> listAll() {
        return provinceService.listAll();
    }

    @GetMapping("/get/id")
    public Province getProvinceById(@RequestParam(value = "province_id", required = false) String province_id) {
        return provinceService.getProvinceById(province_id);
    }

    @GetMapping("/get/name")
    public Province getProvinceByName(@RequestParam(value = "province_name", required = false) String province_name) {
        return provinceService.getProvinceByName(province_name);
    }
}
