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

import vn.aloapp.training.springboot.entity.MeterialCategoryEntity;
import vn.aloapp.training.springboot.entity.UserEntity;
import vn.aloapp.training.springboot.request.MeterialCategory.CRUDMeterialCategoryRequest;
import vn.aloapp.training.springboot.response.BaseResponse;
import vn.aloapp.training.springboot.response.MaterialCategory.MaterialCategoryResponse;
import vn.aloapp.training.springboot.service.MaterialCategoryService;

@RestController
@RequestMapping("/api/category")
public class CategoryController extends BaseController {
	@Autowired
	private MaterialCategoryService meterialService;

	@RequestMapping(value = "/create", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> createCategory(@Valid @RequestHeader("Authorization") String accessToken,
			@RequestBody CRUDMeterialCategoryRequest w) throws Exception {
		BaseResponse response = new BaseResponse();
		UserEntity userIdHeader = this.accessToken(accessToken);
		MeterialCategoryEntity category = meterialService.spUCreateMeterialCategory(userIdHeader.getId(), w);
		response.setData(new MaterialCategoryResponse(category));
		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}/update", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> updateCategory(@Valid @RequestHeader("Authorization") String accessToken,
			@RequestBody CRUDMeterialCategoryRequest w, @PathVariable(name = "id") int id) throws Exception {
		BaseResponse response = new BaseResponse();
		UserEntity user = this.accessToken(accessToken);
		MeterialCategoryEntity mateCategoryEntity = meterialService.findById(id);
		if (mateCategoryEntity == null) {
			response.setStatus(HttpStatus.BAD_REQUEST);
			response.setMessageError("id không đúng");
			return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
		}
		MeterialCategoryEntity mateCategoryDuplicate = meterialService.findByName(w.getName());
		if (mateCategoryDuplicate != null && mateCategoryDuplicate.getId() != id) {
			response.setStatus(HttpStatus.BAD_REQUEST);
			response.setMessageError("tên không đúng");
			return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
		}
		MeterialCategoryEntity category = meterialService.spUpdateMeterialCategory(id, user.getId(), w);
		response.setData(new MaterialCategoryResponse(category));
		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}/update-status", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> updateStatus(@Valid @RequestParam(name = "status") int status,
			@RequestHeader("Authorization") String accessToken, @PathVariable(name = "id") int id) throws Exception {
		BaseResponse response = new BaseResponse();
		this.accessToken(accessToken);
		meterialService.updateStatusCategory(id, status);
		MeterialCategoryEntity meterialCategoryEntity = meterialService.findById(id);
		response.setData(new MaterialCategoryResponse(meterialCategoryEntity));
		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	}
}
