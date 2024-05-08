package com.RevenueManagement.RevenueManagement.controller;//package com.RevenueManagement.RevenueManagement.controller;//package com.RevenueManagement.RevenueManagement.controller;
////import com.RevenueManagement.RevenueManagement.entity.EmployeeDetails;
////import com.RevenueManagement.RevenueManagement.entity.Revenue;
////import com.RevenueManagement.RevenueManagement.repository.EmployeeRepository;
////import com.RevenueManagement.RevenueManagement.repository.RevenueRepository;
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.http.*;
////import org.springframework.web.bind.annotation.*;
////import java.io.IOException;
////import java.io.StringReader;
////
////@RestController
////@RequestMapping("/revenue")
////public class RevenueController {
////
////
////    @Autowired
////    private EmployeeController controller;
////    @Autowired
////    private RevenueRepository repository;
////    @Autowired
////    private EmployeeRepository employeeRepository;
//////
//////    @PostMapping("/add")
//////    public ResponseEntity<String> addReport(@RequestBody Revenue revenue) {
//////        repository.save(revenue);
//////        return new ResponseEntity<>("Record added successfully!", HttpStatus.CREATED);
//////    }
//////
//////    @GetMapping("/download-url")
//////    public ResponseEntity<String> getDownloadUrl() throws IOException {
//////        String reportUrl = "http://localhost:9090/revenue/download";
//////        return new ResponseEntity<>(reportUrl, HttpStatus.OK);
//////    }
//////
//////    @GetMapping("/download")
//////    public ResponseEntity<byte[]> downloadReport() throws IOException {
//////        StringBuilder csvData = new StringBuilder();
//////        // csvData.append("Total Revenue,Monthly Revenue,Profit,Profit Percentage,\n");
//////        csvData.append("Id,Name,Roles,Sal, DOJ \n");
//////        //for (Revenue report : repository.findAll())
//////        for (EmployeeDetails report : employeeRepository.findAll()) {
//////            //csvData.append(String.format("%.2f,%.2f,%.2f,%.2f\n",
//////            csvData.append(String.format("%d,%s,%s,%.2f,%s\n",
//////                    //  report.getTotalRevenue(), report.getMonthlyRevenue(), report.getProfit(), report.getProfitPercentage()));
//////                    report.getId(), report.getName(), report.getRoles(), report.getSal(), report.getDoj()));
//////        }
//////        String data = csvData.toString();
//////        StringReader reader = new StringReader(data);
//////
//////        int character;
//////        StringBuilder csvContent = new StringBuilder();
//////        while ((character = reader.read()) != -1) {
//////            csvContent.append((char) character);
//////        }
//////        byte[] csvBytes = csvContent.toString().getBytes();
//////        HttpHeaders headers = new HttpHeaders();
//////        headers.setContentType(MediaType.parseMediaType("application/csv"));
//////        headers.setContentDisposition(ContentDisposition.attachment()
//////                .filename("employee_report.csv").build());
//////
//////        return new ResponseEntity<>(csvBytes, headers, HttpStatus.OK);
//////    }
//////}
////@PostMapping("/add")
////public ResponseEntity<String> addReport(@RequestBody Revenue revenue) {
////    repository.save(revenue);
////    return new ResponseEntity<>("Record added successfully!", HttpStatus.CREATED);
////}
////
////    @GetMapping("/download-url")
////    public ResponseEntity<String> getDownloadUrl() throws IOException {
////        String reportUrl = "http://localhost:9090/revenue/download";
////        return new ResponseEntity<>(reportUrl, HttpStatus.OK);
////    }
////
////    @GetMapping("/download")
////    public ResponseEntity<String> downloadReport() {
////        StringBuilder xmlData = new StringBuilder();
////        xmlData.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<employees>\n");
////        for (EmployeeDetails employee : employeeRepository.findAll()) {
////            xmlData.append("  <employee>\n");
////            xmlData.append("    <id>").append(employee.getId()).append("</id>\n");
////            xmlData.append("    <name>").append(employee.getName()).append("</name>\n");
////            xmlData.append("    <roles>").append(employee.getRoles()).append("</roles>\n");
////            xmlData.append("    <sal>").append(employee.getSal()).append("</sal>\n");
////            xmlData.append("    <doj>").append(employee.getDoj()).append("</doj>\n");
////            xmlData.append("  </employee>\n");
////        }
////        xmlData.append("</employees>");
////
////        HttpHeaders headers = new HttpHeaders();
////        headers.setContentType(MediaType.APPLICATION_XML);
////        headers.setContentDisposition(ContentDisposition.attachment()
////                .filename("employee_report.xml").build());
////
////        return new ResponseEntity<>(xmlData.toString(), headers, HttpStatus.OK);
////    }
////}
//import com.RevenueManagement.RevenueManagement.entity.EmployeeDetails;
//import com.RevenueManagement.RevenueManagement.entity.Revenue;
//import com.RevenueManagement.RevenueManagement.repository.EmployeeRepository;
//import com.RevenueManagement.RevenueManagement.repository.RevenueRepository;
//import jakarta.servlet.http.HttpServletRequest;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ContentDisposition;
//import org.springframework.http.MediaType;
//
//import java.io.IOException;
import com.RevenueManagement.RevenueManagement.entity.EmployeeDetails;
import com.RevenueManagement.RevenueManagement.entity.Revenue;
import com.RevenueManagement.RevenueManagement.repository.EmployeeRepository;
import com.RevenueManagement.RevenueManagement.repository.RevenueRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/revenue")
public class RevenueController {

    @Autowired
    private EmployeeRepository employeeRepository;
   @Autowired
   private RevenueRepository repository;

    @PostMapping("/add")
    public ResponseEntity<String> addReport(@RequestBody Revenue revenue) {
        repository.save(revenue);
        return new ResponseEntity<>("Record added successfully!", HttpStatus.CREATED);
    }

//    @GetMapping("/download-url")
//    public ResponseEntity<String> getDownloadUrl() throws IOException {
//        String reportUrl = "http://localhost:9090/revenue/download";
//        return new ResponseEntity<>(reportUrl, HttpStatus.OK);
//    }
//
@GetMapping("/download")
public ResponseEntity<String> downloadReport(HttpServletRequest request) {
    StringBuilder xmlData = new StringBuilder();
    xmlData.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<employees>\n");
    for (EmployeeDetails employee : employeeRepository.findAll()) {
        xmlData.append("  <employee>\n");
        xmlData.append("    <id>").append(employee.getId()).append("</id>\n");
        xmlData.append("    <name>").append(employee.getName()).append("</name>\n");
        xmlData.append("    <roles>").append(employee.getRoles()).append("</roles>\n");
        xmlData.append("    <sal>").append(employee.getSal()).append("</sal>\n");
        xmlData.append("    <doj>").append(employee.getDoj()).append("</doj>\n");
        xmlData.append("  </employee>\n");
    }
    xmlData.append("</employees>");

    String filePath = "RevenueManagement/src/sample folder/employee4.xml";
    Path path = Paths.get(filePath);
    try {
        Files.createDirectories(path.getParent());
        Files.write(path, xmlData.toString().getBytes());

    } catch (IOException e) {
        e.printStackTrace(); //
        return new ResponseEntity<>("Failed to save the file to the filesystem.", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    String baseUrl = request.getRequestURL().toString().replace(request.getRequestURI(), "");
    String downloadUrl = baseUrl + "/revenue/download";

    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_XML);
    headers.setContentDisposition(ContentDisposition.attachment()
            .filename("employee_report.xml").build());

    return new ResponseEntity<>(downloadUrl, headers, HttpStatus.OK);
}


}


