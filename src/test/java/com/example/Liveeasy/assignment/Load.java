

package com.example.loads.Liveeasy.assignment;
import java.util.Date;

import com.example.loads.Apis.Load.Enums.LoadingPoint;
import com.example.loads.Apis.Load.Enums.ProductType;
import com.example.loads.Apis.Load.Enums.TruckType;
import com.example.loads.Apis.Load.Enums.UnloadingPoint;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "load")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class Load {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer loadId;

   
    String loadingPoint;

    String unloadingPoint;

    String productType;

    String truckType;

    String noOfTrucks;

    String weight;

    String optional;

    String shipperId;
    
    String date;
}
