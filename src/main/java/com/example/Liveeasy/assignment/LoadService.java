package com.example.Liveeasy.assignment;

import java.util.List;
import org.springframework.stereotype.Service;

import com.example.loads.Apis.Load.DTOs.CreateLoadRequest;
import com.example.loads.Apis.Load.DTOs.UpdateLoadRequest;

@Service
public interface LoadService {
    public String addLoad(CreateLoadRequest createLoadRequest);
    public List<Load> getLoadsByShipperId(String shipperId) throws Exception;
    public Load getLoadByLoadId(Integer loadId) throws Exception;
    public String updateLoadById(Integer loadId, UpdateLoadRequest UpdateLoadRequest) throws Exception;
    public String deleteLoadById(Integer loadId) throws Exception;

}
