//package net.javaguides.springboot.services.employeeHistories;
//
//import lombok.AllArgsConstructor;
//import net.javaguides.springboot.methods.CallApi;
//import net.javaguides.springboot.models.entities.EmployeeHistory;
//import net.javaguides.springboot.models.requests.EmployeeProductRequest;
//import net.javaguides.springboot.models.requests.OrderHistoryRequest;
//import net.javaguides.springboot.repositories.EmployeeHistoryRepository;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//@AllArgsConstructor
//public class EmployeeHistoryServiceImpl implements EmployeeHistoryService {
//    private EmployeeHistoryRepository EmployeeHistoryRepository;
//    private CallApi callApi;
//
//    @Override
//    public List<EmployeeHistory> findByIds(List<Long> ids) {
//        return EmployeeHistoryRepository.findAllByDeletedAtNullAndEmployee_IdIn(ids);
//    }
//
//    @Override
//    public List<EmployeeHistory> findByEmployeeId(Long EmployeeId) {
//        return null;
//    }
//
//    @Override
//    public EmployeeHistory saveModule(OrderHistoryRequest orderHistoryRequest, EmployeeProductRequest EmployeeProductRequest) {
//        return null;
//    }
//
////    @Override
////    public List<EmployeeHistory> moduleSave(List<EmployeeProductRequest> EmployeeProducts, Long brandId, Long partnerId) {
////        List<EmployeeHistory> EmployeeHistories = new ArrayList<>();
////        for (EmployeeProductRequest EmployeeProduct: EmployeeProducts) {
////            EmployeeHistory EmployeeHistory = new EmployeeHistory();
//////            EmployeeHistory.setProductName(EmployeeProduct.getProductName());
////            EmployeeHistory.setPrice(EmployeeHistory.getPrice());
////            EmployeeHistory.setAmount(EmployeeHistory.getAmount());
//////            EmployeeHistory.setReturnable(EmployeeHistory.getReturnable());
////            BrandCategoryRequest brandCategoryRequest = callApi.getCategory(brandId, EmployeeHistory.getCategoryId());
////            EmployeeHistory.setBrandCategoryId(brandCategoryRequest.getId());
////            EmployeeHistory.setCategoryId(EmployeeHistory.getCategoryId());
////            EmployeeHistory.setBrandId(brandId);
////            EmployeeHistory.setPartnerId(partnerId);
////            EmployeeHistory.setPercentage(brandCategoryRequest.getPercentage());
////            EmployeeHistories.add(EmployeeHistory);
////        }
////        return EmployeeHistories;
////    }
//
////    @Override
////    public EmployeeHistory saveModule(OrderHistoryRequest orderHistoryRequest, EmployeeProductRequest EmployeeProductRequest) {
////        EmployeeHistory EmployeeHistory = new EmployeeHistory();
////        EmployeeHistory.setProductName(orderHistoryRequest.getProductName());
////        EmployeeHistory.setAmount(EmployeeProductRequest.getAmount());
////        EmployeeHistory.setBrandCategoryId(orderHistoryRequest.getBrandCategoryId());
////        EmployeeHistory.setBrandId(orderHistoryRequest.getBrandId());
////        EmployeeHistory.setCategoryId(orderHistoryRequest.getCategoryId());
////        EmployeeHistory.setPartnerId(orderHistoryRequest.getPartnerId());
////        EmployeeHistory.setPercentage(orderHistoryRequest.getPercentage());
////        EmployeeHistory.setPrice(orderHistoryRequest.getPrice());
////        EmployeeHistory.setExternalId(orderHistoryRequest.getId());
////        EmployeeHistory.setBonus(orderHistoryRequest.getBonus() * EmployeeProductRequest.getAmount() / orderHistoryRequest.getAmount());
////        EmployeeHistory.setBonusGained(orderHistoryRequest.getBonusGained() * EmployeeProductRequest.getAmount() / orderHistoryRequest.getAmount());
////        EmployeeHistory.setProductId(orderHistoryRequest.getId());
////        return EmployeeHistory;
////    }
//
//    @Override
//    public void saveAll(List<EmployeeHistory> EmployeeHistories) {
////        for (EmployeeHistory EmployeeHistory : EmployeeHistories ) {
////            EmployeeHistory.setEmployee(Employee);
////        }
//        EmployeeHistoryRepository.saveAll(EmployeeHistories);
//    }
//}
//
