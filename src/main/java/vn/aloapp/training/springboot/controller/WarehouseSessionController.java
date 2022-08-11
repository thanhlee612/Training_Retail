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

import com.fasterxml.jackson.databind.ObjectMapper;

import vn.aloapp.training.springboot.entity.UserEntity;
import vn.aloapp.training.springboot.entity.WarehouseDataModel;
import vn.aloapp.training.springboot.request.WareHouseSession.CRUDWarehouseSessionRequest;
import vn.aloapp.training.springboot.response.BaseResponse;
import vn.aloapp.training.springboot.response.WarehouseSession.WarehouseSessionResponse;
import vn.aloapp.training.springboot.service.WarehouseSessionService;

@RestController
@RequestMapping("/api/warehouse")
public class WarehouseSessionController extends BaseController {
	@Autowired
	private WarehouseSessionService warehouseSessionService;

//	@Autowired
//	private WarehouseSessionDetailService serviceDetail;

	@RequestMapping(value = "/export", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> exportWarehouseSession(@RequestHeader("Authorization") String token,
			@RequestBody CRUDWarehouseSessionRequest w) throws Exception {
//		BaseResponse response = new BaseResponse();
//		UserEntity user = this.accessToken(token);
//		ObjectMapper mapper = new ObjectMapper();
//		String json = mapper.writeValueAsString(w.getListDetail());
//		WarehouseDataModel w2 = service.spUCreateWarehouseSessionExprot(user.getId(), json, w);
//		response.setData(new WarehouseSessionResponse(w2));
//		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	
		BaseResponse response = new BaseResponse();
		UserEntity user = this.accessToken(token);
		ObjectMapper mapper = new ObjectMapper();
		try {
			if (user != null) {
				String json = mapper.writeValueAsString(w.getListDetail());
				WarehouseDataModel w2 = warehouseSessionService.spUCreateWarehouseSessionExprot(user.getId(), json, w);
				response.setData(new WarehouseSessionResponse(w2));
			} else {
				response.setStatus(HttpStatus.BAD_REQUEST);
				response.setMessageError("token không đúng");
			}
		} catch (Exception e) {
			response.setStatus(HttpStatus.BAD_REQUEST);
			response.setMessageError(e.getMessage());
		}
		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	}

	@RequestMapping(value = "/import", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> importWarehouseSession(@RequestHeader("Authorization") String token,
			@RequestBody CRUDWarehouseSessionRequest w) throws Exception {
		BaseResponse response = new BaseResponse();
		UserEntity user = this.accessToken(token);
		ObjectMapper mapper = new ObjectMapper();
		try {
			if (user != null) {
				String json = mapper.writeValueAsString(w.getListDetail());
				WarehouseDataModel w2 = warehouseSessionService.spUCreateWarehouseSessionImport(user.getId(), json, w);
				response.setData(new WarehouseSessionResponse(w2));
			} else {
				response.setStatus(HttpStatus.BAD_REQUEST);
				response.setMessageError("token không đúng");
			}
		} catch (Exception e) {
			response.setStatus(HttpStatus.BAD_REQUEST);
			response.setMessageError(e.getMessage());
		}
		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	}

	@RequestMapping(value = "/cancel", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> cancelWarehouseSession(@RequestHeader("Authorization") String token,
			@RequestBody CRUDWarehouseSessionRequest w) throws Exception {
		BaseResponse response = new BaseResponse();
		UserEntity user = this.accessToken(token);
		ObjectMapper mapper = new ObjectMapper();
		try {
			if (user != null) {
				String json = mapper.writeValueAsString(w.getListDetail());
				WarehouseDataModel w2 = warehouseSessionService.spUCreateWarehouseSessionCancel(user.getId(), json, w);
				response.setData(new WarehouseSessionResponse(w2));
			} else {
				response.setStatus(HttpStatus.BAD_REQUEST);
				response.setMessageError("token không đúng");
			}
		} catch (Exception e) {
			response.setStatus(HttpStatus.BAD_REQUEST);
			response.setMessageError(e.getMessage());
		}
		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	}

	@RequestMapping(value = "/return", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> returnWarehouseSession(@RequestHeader("Authorization") String token,
			@RequestBody CRUDWarehouseSessionRequest w) throws Exception {
		BaseResponse response = new BaseResponse();
		UserEntity user = this.accessToken(token);
		ObjectMapper mapper = new ObjectMapper();
		try {
			if (user != null) {
				String json = mapper.writeValueAsString(w.getListDetail());
				WarehouseDataModel w2 = warehouseSessionService.spUCreateWarehouseSessionReturn(user.getId(), json, w);
				response.setData(new WarehouseSessionResponse(w2));
			} else {
				response.setStatus(HttpStatus.BAD_REQUEST);
				response.setMessageError("token không đúng");
			}
		} catch (Exception e) {
			response.setStatus(HttpStatus.BAD_REQUEST);
			response.setMessageError(e.getMessage());
		}
		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	}

//	@RequestMapping(value = "/import1", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
//	public ResponseEntity<BaseResponse> importWarehouse1(@RequestHeader("Authorization") String token,
//			@RequestBody CRUDWarehouseSessionRequest w) throws Exception {
//		BaseResponse response = new BaseResponse();
//		UserEntity user = this.accessToken(token);
//		ObjectMapper mapper = new ObjectMapper();
//		try {
//			if (user != null) {
//				String json = mapper.writeValueAsString(w.getListDetail());
//				WareHouseSessionEntity w2 = warehouseSessionService.spUCreateWarehouseSessionImport1(user.getId(), json, w);
//				StoreProcedureListResult<WarehouseSessionDetailsEntity> listDetail = serviceDetail
//						.spUGetListWahouseDetail(w2.getId());
//				List<WarehouseSessionDetailResponse> listResponse = new WarehouseSessionDetailResponse()
//						.mapToList(listDetail.getResult());
//				response.setData(new WarehouseSessionResponse(w2, listResponse));
//			} else {
//				response.setStatus(HttpStatus.BAD_REQUEST);
//				response.setMessageError("token không đúng");
//			}
//		} catch (Exception e) {
//			response.setStatus(HttpStatus.BAD_REQUEST);
//			response.setMessageError(e.getMessage());
//		}
//		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
//	}

//	@RequestMapping(value = "", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
//	public ResponseEntity<BaseResponse> getAllWarehouseSession(@RequestHeader("Authorization") String token) throws Exception {
//		BaseResponse response = new BaseResponse();
//		UserEntity user = this.accessToken(token);
//		try {
//			if (user != null) {
//				List<WareHouseSessionEntity> listWarehouseSession = service.findAllWarehouseSession();
//				List<WarehouseSessionDetailsEntity> listWarehouseSessionDetail = serviceDetail.findAllWarehouseSessionDetail();
//				response.setData(new WarehouseSessionResponse().mapToListv2(listWarehouseSession, listWarehouseSessionDetail));
//			} else {
//				response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
//				response.setMessageError("User_id hoặc token không đúng");
//			}
//
//		} catch (Exception e) {
//			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
//			response.setMessageError(e.getMessage());
//		}
//		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
//	}

}
