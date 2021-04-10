package com.assigment.hospital.service;

import org.springframework.stereotype.Service;

@Service
public class KetquaxetnghiemService {
    
    private final BenhnhanService benhnhanService;
    private final PhieuxetnghiemService phieuxetnghiemService;
    private final XetnghiemService xetnghiemService;

    public KetquaxetnghiemService(BenhnhanService benhnhanService,
                                  PhieuxetnghiemService phieuxetnghiemService,
                                  XetnghiemService xetnghiemService) {
        this.benhnhanService = benhnhanService;
        this.phieuxetnghiemService = phieuxetnghiemService;
        this.xetnghiemService = xetnghiemService;                          
    }

}
