package vn.aloapp.training.springboot.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import vn.aloapp.training.springboot.entity.MaterialEntity;
import vn.aloapp.training.springboot.entity.StoreProcedureListResult;
import vn.aloapp.training.springboot.entity.UserEntity;
import vn.aloapp.training.springboot.request.MeterialCategory.CRUDMeterialRequest;
import vn.aloapp.training.springboot.response.BaseResponse;
import vn.aloapp.training.springboot.response.MaterialCategory.MaterialResponse;
import vn.aloapp.training.springboot.service.MaterialService;

@RestController
@RequestMapping("/api/materials")
public class MaterialController extends BaseController {
	@Autowired
	private MaterialService meterialService;

	@RequestMapping(value = "/create", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> createMeterial(@RequestHeader("Authorization") String token,
			@RequestBody CRUDMeterialRequest w) throws Exception {
		BaseResponse response = new BaseResponse();
		UserEntity user = this.accessToken(token);
		MaterialEntity meterial = meterialService.spCreateMeterial(user.getId(), w);
		response.setData(new MaterialResponse(meterial));
		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}/update", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> updateMeterial(@RequestHeader("Authorization") String token,
			@RequestBody CRUDMeterialRequest w, @PathVariable(name = "id") int id) throws Exception {
		BaseResponse response = new BaseResponse();
		UserEntity user = this.accessToken(token);
		MaterialEntity materialEntity = meterialService.findById(id);	
		if(materialEntity == null) {
			response.setStatus(HttpStatus.BAD_REQUEST);
			response.setMessageError("Không tìm thấy đơn vị");
			return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
		}
		MaterialEntity materialDuplicateName = meterialService.findByName(w.getName());
		if(materialDuplicateName != null && materialDuplicateName.getId() != id) {
			response.setStatus(HttpStatus.BAD_REQUEST);
			response.setMessageError("Nguyen lieu da co");
			return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
		}
		MaterialEntity materialUpdate =  meterialService.spUpdateMeterial(id, user.getId(), w);
		response.setData(new MaterialResponse(materialUpdate));
		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}/update-status", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> updateStatus(@Valid @RequestParam(name = "status") int status,
			@RequestHeader("Authorization") String accessToken, @PathVariable(name = "id") int id) throws Exception {
		BaseResponse response = new BaseResponse();
		this.accessToken(accessToken);
		MaterialEntity meterial = meterialService.updateStatusMeterial(id, status);
		response.setData(new MaterialResponse(meterial));
		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	}

	@RequestMapping(value = "", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> getAllMaterial(@RequestParam(name = "status") int status,
			@RequestHeader("Authorization") String accessToken) throws Exception {
		BaseResponse response = new BaseResponse();
		this.accessToken(accessToken);
		StoreProcedureListResult<MaterialEntity> meterials = meterialService.getStatus(status);
		response.setData(new MaterialResponse().mapToList(meterials.getResult()));
		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	}
}
