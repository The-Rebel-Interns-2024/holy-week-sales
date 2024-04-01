package com.serbatic.holyweeksales.business.services.productExit;


import com.serbatic.holyweeksales.data.entities.Product;
import com.serbatic.holyweeksales.presentation.dto.ProductExitResponse;
import com.serbatic.holyweeksales.presentation.dto.ProductResource;
import com.serbatic.holyweeksales.presentation.dto.ProductResponse;
import com.serbatic.holyweeksales.presentation.dto.StorageResource;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface ProductExitService {

//    Product findByCode(String code);
    ProductExitResponse createProductExit (StorageResource storageResource);
}
