package com.example.Liveasy.assigment;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.loads.Apis.Load.Load;
import com.example.loads.Apis.Load.DTOs.CreateLoadRequest;
import com.example.loads.Apis.Load.DTOs.UpdateLoadRequest;

@Service
public class LoadServiceImpl implements LoadService {

    @Autowired
    LoadRepository loadRepository;

    @Override
    public String addLoad(CreateLoadRequest createLoadRequest) {

        Load load = createLoadToLoad(createLoadRequest);
        loadRepository.save(load); 
        return "Loads details added successfully";
      
    }

    @Override
    public List<Load> getLoadsByShipperId(String shipperId) throws Exception {
        List<Load> loads;
        try{
            loads = loadRepository.findByShipperId(shipperId);
            return loads;
        }
        catch(Exception e)
        {
            throw new Exception("No loads exist in this shipperID");
        }
    }

    @Override
    public Load getLoadByLoadId(Integer loadId) throws Exception {
        Load load;
        try{
            load = loadRepository.findById(loadId).get();
            return load;
        }
        catch(Exception e)
        {
            throw new Exception("Invalid LoadId!!!");
        }
    }

    @Override
    public String updateLoadById(Integer loadId, UpdateLoadRequest updateLoad) throws Exception{
        Load load;
        try{
            load = loadRepository.findById(loadId).get();
            updateLoadToLoad(updateLoad, load);
            loadRepository.save(load);
            return "Load updated successfully!!!";
        }
        catch(Exception e)
        {
            throw new Exception("Invalid LoadId!!!");
        }
    }

    @Override
    public String deleteLoadById(Integer loadId) throws Exception {
        
        Load load;
        try{
            load = loadRepository.findById(loadId).get();
            loadRepository.delete(load);
            return "Load removed successfully!!!";
        }
        catch(Exception e)
        {
            throw new Exception("Invalid LoadId!!!");
        }
    }

   
    public static Load createLoadToLoad(CreateLoadRequest createLoadRequest) {
        Load load = new Load();
    
        // Set the attributes individually
        load.setLoadingPoint(createLoadRequest.getLoadingPoint());
        load.setUnloadingPoint(createLoadRequest.getUnloadingPoint());
        load.setProductType(createLoadRequest.getProductType());
        load.setTruckType(createLoadRequest.getTruckType());
        load.setNoOfTrucks(createLoadRequest.getNoOfTrucks());
        load.setShipperId(createLoadRequest.getShipperId());
        load.setWeight(createLoadRequest.getWeight());
        load.setOptional(createLoadRequest.getOptional());
        load.setDate(createLoadRequest.getDate());
    
        return load;
    }

    public static Load updateLoadToLoad(UpdateLoadRequest updateLoad, Load load) {
        load.setLoadingPoint(updateLoad.getLoadingPoint());
        load.setUnloadingPoint(updateLoad.getUnloadingPoint());
        load.setProductType(updateLoad.getProductType());
        load.setTruckType(updateLoad.getTruckType());
        load.setNoOfTrucks(updateLoad.getNoOfTrucks());
        load.setWeight(updateLoad.getWeight());
        load.setOptional(updateLoad.getOptional());
        load.setDate(updateLoad.getDate());
    
        return load;
    }
    
    
    
   
    
}
