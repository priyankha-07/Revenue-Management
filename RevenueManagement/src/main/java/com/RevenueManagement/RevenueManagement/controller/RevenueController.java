package com.RevenueManagement.RevenueManagement.controller;
import com.RevenueManagement.RevenueManagement.entity.EmployeeDetails;
import com.RevenueManagement.RevenueManagement.entity.Revenue;
import com.RevenueManagement.RevenueManagement.repository.EmployeeRepository;
import com.RevenueManagement.RevenueManagement.repository.RevenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.io.StringReader;

@RestController
@RequestMapping("/revenue")
public class RevenueController {


    @Autowired
    private EmployeeController controller;
    @Autowired
    private RevenueRepository repository;
    @Autowired
    private EmployeeRepository employeeRepository;
//
//    @PostMapping("/add")
//    public ResponseEntity<String> addReport(@RequestBody Revenue revenue) {
//        repository.save(revenue);
//        return new ResponseEntity<>("Record added successfully!", HttpStatus.CREATED);
//    }
//
//    @GetMapping("/download-url")
//    public ResponseEntity<String> getDownloadUrl() throws IOException {
//        String reportUrl = "http://localhost:9090/revenue/download";
//        return new ResponseEntity<>(reportUrl, HttpStatus.OK);
//    }
//
//    @GetMapping("/download")
//    public ResponseEntity<byte[]> downloadReport() throws IOException {
//        StringBuilder csvData = new StringBuilder();
//        // csvData.append("Total Revenue,Monthly Revenue,Profit,Profit Percentage,\n");
//        csvData.append("Id,Name,Roles,Sal, DOJ \n");
//        //for (Revenue report : repository.findAll())
//        for (EmployeeDetails report : employeeRepository.findAll()) {
//            //csvData.append(String.format("%.2f,%.2f,%.2f,%.2f\n",
//            csvData.append(String.format("%d,%s,%s,%.2f,%s\n",
//                    //  report.getTotalRevenue(), report.getMonthlyRevenue(), report.getProfit(), report.getProfitPercentage()));
//                    report.getId(), report.getName(), report.getRoles(), report.getSal(), report.getDoj()));
//        }
//        String data = csvData.toString();
//        StringReader reader = new StringReader(data);
//
//        int character;
//        StringBuilder csvContent = new StringBuilder();
//        while ((character = reader.read()) != -1) {
//            csvContent.append((char) character);
//        }
//        byte[] csvBytes = csvContent.toString().getBytes();
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.parseMediaType("application/csv"));
//        headers.setContentDisposition(ContentDisposition.attachment()
//                .filename("employee_report.csv").build());
//
//        return new ResponseEntity<>(csvBytes, headers, HttpStatus.OK);
//    }
//}
@PostMapping("/add")
public ResponseEntity<String> addReport(@RequestBody Revenue revenue) {
    repository.save(revenue);
    return new ResponseEntity<>("Record added successfully!", HttpStatus.CREATED);
}

    @GetMapping("/download-url")
    public ResponseEntity<String> getDownloadUrl() throws IOException {
        String reportUrl = "http://localhost:9090/revenue/download";
        return new ResponseEntity<>(reportUrl, HttpStatus.OK);
    }

    @GetMapping("/download")
    public ResponseEntity<String> downloadReport() {
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

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_XML);
        headers.setContentDisposition(ContentDisposition.attachment()
                .filename("employee_report.xml").build());

        return new ResponseEntity<>(xmlData.toString(), headers, HttpStatus.OK);
    }
}