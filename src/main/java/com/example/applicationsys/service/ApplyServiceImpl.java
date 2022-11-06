package com.example.applicationsys.service;

import com.example.applicationsys.dto.Apply;
import com.example.applicationsys.dto.Lecture;
import com.example.applicationsys.mapper.master.ApplyWriteMapper;
import com.example.applicationsys.mapper.master.LectureWriteMapper;
import com.example.applicationsys.mapper.read.LectureReadMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class ApplyServiceImpl implements ApplyService{

    private LectureWriteMapper lectureWriteMapper;
    private LectureReadMapper lectureReadMapper;
    private ApplyWriteMapper applyWriteMapper;

    public ApplyServiceImpl(LectureWriteMapper lectureWriteMapper, LectureReadMapper lectureReadMapper, ApplyWriteMapper applyWriteMapper){
        this.lectureWriteMapper=lectureWriteMapper;
        this.lectureReadMapper=lectureReadMapper;
        this.applyWriteMapper=applyWriteMapper;
    }

    @Transactional
    @Override
    public synchronized void apply(Apply apply) {
        // maxperson < 20
        Lecture lecture = lectureReadMapper.findById(apply.getLectureId());
        if(lecture.getMaxPerson() > lecture.getNowPerson()){
                lectureWriteMapper.updateNowPerson(lecture.getNowPerson()+1, lecture.getId());
                applyWriteMapper.apply(apply);
        }else {
            //throw new RuntimeException("최대 수강인원이 초과되었습니다.");
        }
    }
}
