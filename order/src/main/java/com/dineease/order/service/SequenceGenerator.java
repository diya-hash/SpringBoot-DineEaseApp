package com.dineease.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.dineease.order.entity.Sequence;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;

@Service
public class SequenceGenerator {
	@Autowired
	MongoOperations mongoOperations;
	
    public int generateNextOrderId(){
       Sequence counter = mongoOperations.findAndModify(
        		Query.query(Criteria.where("_id").is("sequence")),
        		new Update().inc("sequence", 1), 
        		options().returnNew(true).upsert(true), 
        		Sequence.class);
        return counter.getSequence();
    }
}