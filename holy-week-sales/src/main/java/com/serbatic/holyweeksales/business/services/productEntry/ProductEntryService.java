package com.serbatic.holyweeksales.business.services.productEntry;

import com.serbatic.holyweeksales.business.services.product.ProductService;
import com.serbatic.holyweeksales.clients.StorehouseFeingClient;
import com.serbatic.holyweeksales.presentation.dto.ProductEntryResponse;
import com.serbatic.holyweeksales.presentation.dto.StorageResource;

public interface ProductEntryService {
    ProductEntryResponse save(StorageResource storageResource);
}
