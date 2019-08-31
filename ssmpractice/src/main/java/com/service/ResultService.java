package com.service;

import com.domain.Result;

import java.util.List;

public interface ResultService {
    void add(Result result);
    List<Result> find(int userId);
}
