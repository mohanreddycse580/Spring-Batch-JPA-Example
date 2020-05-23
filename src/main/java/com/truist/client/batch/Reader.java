package com.truist.client.batch;

import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.core.io.Resource;

import com.truist.client.entity.UsersVO;

public class Reader extends FlatFileItemReader<UsersVO> {

	public Reader(Resource resource) {
		super();
		setResource(resource);
		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
		lineTokenizer.setNames(new String[] { "userid", "name", "dept", "amount" });
		lineTokenizer.setDelimiter(",");
		lineTokenizer.setStrict(false);

		BeanWrapperFieldSetMapper<UsersVO> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
		fieldSetMapper.setTargetType(UsersVO.class);

		DefaultLineMapper<UsersVO> defaultLineMapper = new DefaultLineMapper<>();
		defaultLineMapper.setLineTokenizer(lineTokenizer);
		defaultLineMapper.setFieldSetMapper(fieldSetMapper);
		setLineMapper(defaultLineMapper);
	}
}
