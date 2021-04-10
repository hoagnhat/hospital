package com.assigment.hospital.service;

import java.sql.Date;
import java.util.List;

import com.assigment.hospital.entity.BenhnhanEntity;
import com.assigment.hospital.entity.NhanvienEntity;
import com.assigment.hospital.entity.PhieuxetnghiemEntity;
import com.assigment.hospital.entity.PxnXnEntity;
import com.assigment.hospital.entity.XetnghiemEntity;
import com.assigment.hospital.repository.PhieuxetnghiemRepository;

import org.springframework.stereotype.Service;

@Service
public class PhieuxetnghiemService {

    private final BenhnhanService benhNhanService;
    private final NhanvienService nhanvienService;
    private final XetnghiemService xetnghiemService;
    private final PxnXnService pxnXnService;
    private final PhieuxetnghiemRepository repository;

    public PhieuxetnghiemService(BenhnhanService benhnhanService, 
                                 PhieuxetnghiemRepository repository, 
                                 XetnghiemService xetnghiemService,
                                 PxnXnService pxnXnService,
                                 NhanvienService nhanvienService) {
        this.benhNhanService = benhnhanService;
        this.repository = repository;
        this.xetnghiemService = xetnghiemService;
        this.pxnXnService = pxnXnService;
        this.nhanvienService = nhanvienService;
    }

    public void savePhieuxetnghiem(long mabn, List<Long> maxn, List<Integer> listketqua, List<String> listghichu) {
        BenhnhanEntity benhNhan = benhNhanService.getById(mabn);
        PhieuxetnghiemEntity phieuxetnghiem = new PhieuxetnghiemEntity();

        // TODO: Need to change with Current User
        NhanvienEntity nhanVien = nhanvienService.getById(2);
        // Set name for bac si chi dinh
        phieuxetnghiem.setNhanvienByManv(nhanVien);

        phieuxetnghiem.setBenhnhanByMabn(benhNhan);
        phieuxetnghiem = repository.saveAndFlush(phieuxetnghiem);
        long millis=System.currentTimeMillis();
        Date ngayChiDinh = new Date(millis);
        for (int i = 0; i < maxn.size(); i++) {
            XetnghiemEntity xetnghiem = xetnghiemService.getById(maxn.get(i));
            PxnXnEntity pxnxn = new PxnXnEntity();
            pxnxn.setMapxn(phieuxetnghiem.getMapxn());
            pxnxn.setMaxn(xetnghiem.getMaxn());
            pxnxn.setKetqua(listketqua.get(i));
            pxnxn.setGhichu(listghichu.get(i));
            pxnxn.setNgaychidinh(ngayChiDinh);
            pxnXnService.savePxnXn(pxnxn);
        }
    }
}
