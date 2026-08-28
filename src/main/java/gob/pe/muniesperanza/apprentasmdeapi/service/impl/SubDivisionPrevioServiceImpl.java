package gob.pe.muniesperanza.apprentasmdeapi.service.impl;


import gob.pe.muniesperanza.apprentasmdeapi.bean.SubDivisionPrevioBean;
import gob.pe.muniesperanza.apprentasmdeapi.repository.SubDivisionPrevioIDAO;
import gob.pe.muniesperanza.apprentasmdeapi.service.SubDivisionPrevioService;
import gob.pe.muniesperanza.apprentasmdeapi.util.ClsResultDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SubDivisionPrevioServiceImpl implements SubDivisionPrevioService {

    private final SubDivisionPrevioIDAO subDivisionPrevioIDAO;

    public SubDivisionPrevioServiceImpl(SubDivisionPrevioIDAO subDivisionPrevioIDAO) {
        this.subDivisionPrevioIDAO = subDivisionPrevioIDAO;
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
    @Override
    public ClsResultDAO subDivisionPrevio(SubDivisionPrevioBean subDivisionPrevioBean)  throws Exception {
        // TODO Auto-generated method stub
        ClsResultDAO objResultDAO = new ClsResultDAO();
        try {
            objResultDAO =  subDivisionPrevioIDAO.subDivisionPrevio(subDivisionPrevioBean);
            if (objResultDAO.get(objResultDAO.CODIGO_RESPUESTA).equals(objResultDAO.ERROR_THROW)) {
                return objResultDAO;
            }
        } catch (Exception e) {
            // TODO: handle exception
            //log.error(e.getMessage(), e);
            throw new Exception(e.getMessage(), e);
        }
        return objResultDAO;
    }


}
