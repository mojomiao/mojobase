package com.mojo.base.dp;

import java.util.ArrayList;
import java.util.List;

public class FilterChain implements StudyPrepareFilter {
    
    
    private int pos = 0;//标识过滤器的下标，当pos为studyPrepareFilters的size时终止过滤器
    
    private final Study study;//兜底
    
    private List<StudyPrepareFilter> studyPrepareFilters;//所有过滤器的列表
    
    public FilterChain(Study study) {
        this.study = study;
    }
    
    public void addFilter(StudyPrepareFilter studyPrepareFilter) {
        if (studyPrepareFilters == null) {
            studyPrepareFilters = new ArrayList<>();
        }
        studyPrepareFilters.add(studyPrepareFilter);
    }
    
    @Override
    public void doFilter(PreparationList preparationList, FilterChain filterChain) {
        if (pos == studyPrepareFilters.size()) {//全部过滤器执行完毕后兜底
            study.study();
        }else {
            studyPrepareFilters
                    .get(pos++)//pos++表示每次经过一个过滤器处理便向后移动一位
                    .doFilter(preparationList, filterChain);
        }
        
    }
}
