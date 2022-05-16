package com.cdw.store.api;

import com.cdw.store.dto.BillDto;
import com.cdw.store.dto.ProductDto;
import com.cdw.store.service.impl.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bill")
public class BillResource {
 @Autowired
    private BillService billService ;
    @GetMapping("/all")
    public ResponseEntity<List<BillDto>> getAllBills(){
        List<BillDto> bills = billService.findAll();
        return new ResponseEntity<List<BillDto>>(bills, HttpStatus.OK);
    }
    @GetMapping(value = "/allU")
    public ResponseEntity<List<BillDto>> getAllBillsByUserId(@RequestParam("userId") Long id){
        List<BillDto> bills = billService.findALlByUserId(id);
        return new ResponseEntity<List<BillDto>>(bills, HttpStatus.OK);
    }
}
