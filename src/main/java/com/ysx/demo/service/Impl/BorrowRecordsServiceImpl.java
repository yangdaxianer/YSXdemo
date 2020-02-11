package com.ysx.demo.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ysx.demo.mapper.BorrowRecordsMapper;
import com.ysx.demo.model.BorrowRecords;
import com.ysx.demo.service.BorrowRecordsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class BorrowRecordsServiceImpl extends ServiceImpl<BorrowRecordsMapper, BorrowRecords> implements BorrowRecordsService {
}
