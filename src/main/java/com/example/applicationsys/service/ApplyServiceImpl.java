package com.example.applicationsys.service;

import com.example.applicationsys.dto.Apply;
import com.example.applicationsys.dto.Lecture;
import com.example.applicationsys.mapper.ApplyMapper;
import com.example.applicationsys.mapper.LectureMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class ApplyServiceImpl implements ApplyService{

    private LectureMapper lectureMapper;
    private ApplyMapper applyMapper;

    public ApplyServiceImpl(LectureMapper lectureMapper, ApplyMapper applyMapper){
        this.lectureMapper=lectureMapper;
        this.applyMapper=applyMapper;
    }

    @Transactional
    @Override
    public synchronized void apply(Apply apply) {
        // maxperson < 20
        Lecture lecture = lectureMapper.findById(apply.getLectureId());
        System.out.println(111222);
        if(lecture.getMaxPerson() > lecture.getNowPerson()){
                lectureMapper.updateNowPerson(lecture.getNowPerson()+1, lecture.getId());
                applyMapper.apply(apply);
        }else {
            //throw new RuntimeException("최대 수강인원이 초과되었습니다.");
        }
    }
}
