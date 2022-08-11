package vn.aloapp.training.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import vn.aloapp.training.springboot.entity.StoreProcedureListResult;
import vn.aloapp.training.springboot.entity.UserEntity;
import vn.aloapp.training.springboot.request.Report.CRUDReportRequest;
import vn.aloapp.training.springboot.response.BaseResponse;
import vn.aloapp.training.springboot.response.Report.HotSellingProductReport;
import vn.aloapp.training.springboot.response.Report.HotSellingProductResponse;
import vn.aloapp.training.springboot.response.Report.RetailReport;
import vn.aloapp.training.springboot.response.Report.RetailReportResponse;
import vn.aloapp.training.springboot.response.Report.RevenuesResponse;
import vn.aloapp.training.springboot.response.Report.WarehouseSessionReport;
import vn.aloapp.training.springboot.response.Report.WarehouseSessionReportResponse;
import vn.aloapp.training.springboot.service.HotSellingProductService;
import vn.aloapp.training.springboot.service.RetailReportService;
import vn.aloapp.training.springboot.service.RevenuesService;
import vn.aloapp.training.springboot.service.WarehouseSessionReportService;

@RestController
@RequestMapping("/api/reports")
public class ReportController extends BaseController {
	@Autowired
	private RevenuesService revenuesService;

	@Autowired
	private HotSellingProductService hotSellingProductService;

	@Autowired
	private WarehouseSessionReportService warehouseSessionReportService;

//	@Autowired
//	private ProductOutService productOutService;

	@Autowired
	private RetailReportService reportService;

	@RequestMapping(value = "/profit", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> revenues(@RequestHeader("Authorization") String token) throws Exception {
		BaseResponse response = new BaseResponse();
		this.accessToken(token);
		response.setData(new RevenuesResponse(revenuesService.revenuesReport()));
		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	}

	@RequestMapping(value = "/bestseller", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> hotSelling(@RequestHeader("Authorization") String token) throws Exception {
		BaseResponse response = new BaseResponse();
		this.accessToken(token);
		StoreProcedureListResult<HotSellingProductReport> listResult = hotSellingProductService
				.hotSellingProductPReport();
		response.setData(new HotSellingProductResponse().mapToList(listResult.getResult()));
		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	}

	@RequestMapping(value = "/inventory-report", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> warehouseReport(@RequestHeader("Authorization") String token) throws Exception {
		BaseResponse response = new BaseResponse();
		this.accessToken(token);
		StoreProcedureListResult<WarehouseSessionReport> report = warehouseSessionReportService
				.warehouseSessionReport();
		response.setData(new WarehouseSessionReportResponse().mapToList(report.getResult()));
		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	}



	@RequestMapping(value = "/report", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> report(@RequestHeader("Authorization") String token,
			@RequestBody CRUDReportRequest w) throws Exception {
		BaseResponse response = new BaseResponse();
		UserEntity user = this.accessToken(token);
		try {
			if (user != null) {
				StoreProcedureListResult<RetailReport> report = reportService.retailReport(user.getId(), w);
				response.setData(new RetailReportResponse().mapToList(report.getResult()));
			} else {
				response.setStatus(HttpStatus.BAD_REQUEST);
				response.setMessageError("Token không đúng");
			}
		} catch (Exception e) {
			response.setStatus(HttpStatus.BAD_REQUEST);
			response.setMessageError(e.getMessage());
		}
		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	}
	
	/*
	 * @RequestMapping(value = "/out-of-stock", method = RequestMethod.GET, produces
	 * = { MediaType.APPLICATION_JSON_VALUE }) public ResponseEntity<BaseResponse>
	 * productOut(@RequestHeader("Authorization") String token) throws Exception {
	 * BaseResponse response = new BaseResponse(); UserEntity user =
	 * this.accessToken(token); try { if (user != null) {
	 * StoreProcedureListResult<ProductOutReport> report =
	 * productOutService.productOutReport(); response.setData(new
	 * ProductOutReportResponse().mapToList(report.getResult())); } else {
	 * response.setStatus(HttpStatus.BAD_REQUEST);
	 * response.setMessageError("token không đúng"); } } catch (Exception e) {
	 * response.setStatus(HttpStatus.BAD_REQUEST);
	 * response.setMessageError(e.getMessage()); } return new
	 * ResponseEntity<BaseResponse>(response, HttpStatus.OK); }
	 */
}
