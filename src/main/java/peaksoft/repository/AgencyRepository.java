package peaksoft.repository;

import peaksoft.model.Agency;

import java.util.List;

public interface AgencyRepository {
    void saveAgency(Agency agency);
    Agency getAgencyById(Long id);
    List<Agency> getAllAgencies();
    void updateAgency(Long id,Agency newAgency);
    void deleteAgencyById(Long id);
    List<Agency> search(String keyWord);
}
