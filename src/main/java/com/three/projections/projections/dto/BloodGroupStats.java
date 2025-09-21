package com.three.projections.projections.dto;

import com.three.projections.projections.entity.type.BloodGroupType;
import lombok.Data;

    @Data
    public class BloodGroupStats {
        private final BloodGroupType bloodGroupType;
        private final Long count;
    }

