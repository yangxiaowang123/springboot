package com.forezp.dao;

import com.forezp.entity.BBOSSHttpReqLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by jh on 2017/7/25.
 */
@Repository
public interface BBOSSHttpReqLogRepository extends JpaRepository<BBOSSHttpReqLog, String> {
}
