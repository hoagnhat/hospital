package com.assigment.hospital.service;

import java.util.ArrayList;
import java.util.List;

import com.assigment.hospital.entity.BenhnhanEntity;
import com.assigment.hospital.entity.KetquaxetnghiemDTO;
import com.assigment.hospital.entity.NhanvienEntity;
import com.assigment.hospital.entity.PhieukhambenhEntity;
import com.assigment.hospital.entity.PhieuxetnghiemEntity;
import com.assigment.hospital.entity.PxnXnEntity;
import com.assigment.hospital.entity.XetnghiemEntity;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class KetquaxetnghiemService {
    
    private final BenhnhanService benhnhanService;
    private final NhanvienService nhanvienService;
    private final PhieuxetnghiemService phieuxetnghiemService;
    private final PhieukhambenhService phieukhambenhService;
    private final XetnghiemService xetnghiemService;
    private final PxnXnService pxnXnService;

    public KetquaxetnghiemService(BenhnhanService benhnhanService,
                                  PhieuxetnghiemService phieuxetnghiemService,
                                  XetnghiemService xetnghiemService,
                                  PxnXnService pxnXnService,
                                  NhanvienService nhanvienService,
                                  PhieukhambenhService phieukhambenhService) {
        this.benhnhanService = benhnhanService;
        this.phieuxetnghiemService = phieuxetnghiemService;
        this.xetnghiemService = xetnghiemService;
        this.pxnXnService = pxnXnService;
        this.nhanvienService = nhanvienService;
        this.phieukhambenhService = phieukhambenhService;              
    }

    public Model showKetQua(long mabn, Model model) {
        BenhnhanEntity benhNhan = benhnhanService.getById(mabn);
        if (benhNhan != null) {
            PhieuxetnghiemEntity phieuxetnghiem = phieuxetnghiemService.getByMabn(mabn);
            NhanvienEntity bacSiXetnghiem = nhanvienService.getById(phieuxetnghiem.getManv());
            PhieukhambenhEntity phieukhambenh = phieukhambenhService.getByMabn(mabn);

            NhanvienEntity bacSiChiDinh = nhanvienService.getById(phieukhambenh.getManv());
            List<PxnXnEntity> listPxnXn = pxnXnService.getByMapxn(phieuxetnghiem.getMapxn());
            List<KetquaxetnghiemDTO> listKQXetnghiem = new ArrayList<KetquaxetnghiemDTO>();
            for (int i = 0; i < listPxnXn.size(); i++) {
                XetnghiemEntity xetnghiem = xetnghiemService.getById(listPxnXn.get(i).getMaxn());
                KetquaxetnghiemDTO ketqua = new KetquaxetnghiemDTO(xetnghiem.getMaxn(), xetnghiem.getTenxn(),
                                                                    xetnghiem.getDonvi(), listPxnXn.get(i).getKetqua(),
                                                                    listPxnXn.get(i).getGhichu());
                listKQXetnghiem.add(ketqua);
            }

            model.addAttribute("benhNhan", benhNhan);
            model.addAttribute("phieukhambenh", phieukhambenh);
            model.addAttribute("phieuxetnghiem", phieuxetnghiem);
            model.addAttribute("listKQXetnghiem", listKQXetnghiem);
            model.addAttribute("bacSiChiDinh", bacSiChiDinh);
            model.addAttribute("bacSiXetnghiem", bacSiXetnghiem);
            if (benhNhan.getGioiTinh()) {
                model.addAttribute("gioitinh", "Nam");
            } else {
                model.addAttribute("gioitinh", "Nữ");
            }
            return model;
        }

        return null;
    }

}
