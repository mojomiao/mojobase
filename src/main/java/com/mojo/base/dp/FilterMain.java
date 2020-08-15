package com.mojo.base.dp;

public class FilterMain {
    
    public static void main(String[] args) {
        
        PreparationList preparationList = new PreparationList();
        preparationList.setWashHair(true);
        preparationList.setWashFace(true);
        
        Study study = new Study();
        
        StudyPrepareFilter washHairFilter = new WashHairFilter();
        StudyPrepareFilter washFaceFilter = new WashFaceFilter();
        
        FilterChain filterChain = new FilterChain(study);
        filterChain.addFilter(washHairFilter);
        filterChain.addFilter(washFaceFilter);
        
        filterChain.doFilter(preparationList, filterChain);
    }
}
