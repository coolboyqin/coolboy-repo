package com.service.impl;

import com.domain.Result;
import com.mapper.ResultMapper;
import com.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultServiceImpl  implements ResultService {
    @Autowired
    private ResultMapper resultMapper;
    @Override
    public void add(Result result) {
        resultMapper.add(result);
    }

    @Override
    public List<Result> find(int userId) {
    return resultMapper.find(userId);
    }


}
