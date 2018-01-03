package com.forezp.dao;

import com.forezp.entity.BBOSSHttpRspLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by jh on 2017/7/25.
 */
@Repository
public interface BBOSSHttpRspLogRepository extends JpaRepository<BBOSSHttpRspLog, String> {
}
