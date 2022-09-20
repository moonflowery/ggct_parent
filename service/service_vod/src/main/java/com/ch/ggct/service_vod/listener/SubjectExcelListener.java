package com.ch.ggct.service_vod.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.ch.ggct.model.vod.Subject;
import com.ch.ggct.service_vod.mapper.SubjectMapper;
import com.ch.ggct.vo.vod.SubjectEeVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author chenghao
 * @purpose：
 * @备注：
 * @data 2022年09月20日 10:45
 */
@Component
public class SubjectExcelListener extends AnalysisEventListener<SubjectEeVo> {
    @Autowired
    private SubjectMapper subjectMapper;
    //一行一行，从第二行开始读取
    @Override
    public void invoke(SubjectEeVo subjectEeVo, AnalysisContext analysisContext) {
        Subject subject = new Subject();
        BeanUtils.copyProperties(subjectEeVo,subject);
        subjectMapper.insert(subject);

    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
