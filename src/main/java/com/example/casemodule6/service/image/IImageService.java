package com.example.casemodule6.service.image;

import com.example.casemodule6.model.entity.Image;
import com.example.casemodule6.service.IGeneralService;

public interface IImageService extends IGeneralService<Image> {
    Iterable<Image> findAllImageByHouseId(Long id);
}
