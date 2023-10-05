package com.example.Liveesy.assignment;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.loads.Apis.Load.DTOs.CreateLoadRequest;
import com.example.loads.Apis.Load.DTOs.UpdateLoadRequest;

@RestController
@RequestMapping("/load")
public class LoadController {
    @Autowired
    LoadService loadService;
@PostMapping("/add")
public ResponseEntity addLoad(@RequestBody CreateLoadRequest createLoadRequest)
{
    try{
        String response = loadService.addLoad(createLoadRequest);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }
    catch(Exception e)
    {
        return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}

@GetMapping("get-loads/shipperId")
public ResponseEntity getLoadsByShipperId(@RequestParam(name = "shipperId") String shipperId)
{
    try{
        List<Load> loads = loadService.getLoadsByShipperId(shipperId);
        return new ResponseEntity(loads, HttpStatus.CREATED);
    }
    catch(Exception e)
    {
        return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
@GetMapping("/get-load-by-id/{loadId}")
public ResponseEntity getLoadByLoadId(@PathVariable Integer loadId)
{
    try{
        Load load = loadService.getLoadByLoadId(loadId);
        return new ResponseEntity(load, HttpStatus.CREATED);
    }
    catch(Exception e)
    {
        return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}

@GetMapping("/update-load-by-id/{loadId}")
public ResponseEntity updateLoadById(@PathVariable Integer loadId, @RequestBody UpdateLoadRequest updateLoad)
{
    try{
        String response = loadService.updateLoadById(loadId,updateLoad);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }
    catch(Exception e)
    {
        return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}

@DeleteMapping("/delete/{loadId}")
public ResponseEntity deleteLoadById(@PathVariable Integer loadId)
{
    try{
        String response = loadService.deleteLoadById(loadId);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }
    catch(Exception e)
    {
        return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
    
}
