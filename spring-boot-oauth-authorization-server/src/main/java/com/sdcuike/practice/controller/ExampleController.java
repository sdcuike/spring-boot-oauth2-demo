package com.sdcuike.practice.controller;

import com.doctor.beaver.domain.result.ModelResult;
import com.sdcuike.practice.domain.Company;
import com.sdcuike.practice.mapper.CompanyMapper;
import com.sdcuike.spring.extend.web.util.PaginationUtil;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping(path = "/example", produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class ExampleController {
    
    @Resource
    private CompanyMapper companyMapper;
    
    @GetMapping("/")
    public ModelResult<String> home() {
        ModelResult<String> modelResult = new ModelResult<>();
        modelResult.setData("hello world spring boot");
        return modelResult;
    }
    
    @GetMapping("/all_company")
    public List<Company> queryAllCompany() {
        return companyMapper.selectAll();
    }
    
    @ApiOperation(value = "queryCompanys", notes = "获取 公司分页")
    @GetMapping("/all_company/page")
    public ModelResult<List<Company>> queryCompanys(Pageable pageable,
                                                    HttpServletRequest request,
                                                    HttpServletResponse response) throws URISyntaxException {
        
        ModelResult<List<Company>> result = new ModelResult<>();
        Page<Company> companies = companyMapper.selectAllPageable(pageable);
        result.setData(companies.getContent());
        
        PaginationUtil.setPaginationHttpHeaders(companies, request,response);
        return result;
    }
    
    @PostMapping("/company")
    public void insertCompany(@RequestBody Company company){
        companyMapper.insert(company);
    
    }
    @Data
    public static class QueryCompanysResponseDto {
        private List<Company> companies;
        private Pageable pageable;
    }
}
