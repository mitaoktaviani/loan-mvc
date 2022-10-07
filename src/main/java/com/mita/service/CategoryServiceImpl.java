package com.mita.service;

import com.mita.repository.CategoryRepository;
import com.mita.utility.DropDown;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<DropDown> categoryDropDown() {
        List<DropDown> category = categoryRepository.getCategoryDropDown();
        return category;
    }
}
