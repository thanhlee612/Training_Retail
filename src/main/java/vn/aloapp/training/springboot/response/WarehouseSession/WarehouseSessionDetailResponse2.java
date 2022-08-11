package vn.aloapp.training.springboot.response.WarehouseSession;

import java.util.List;

public class WarehouseSessionDetailResponse2 {

	private int total;
	private List<WarehouseSessionDetailResponse> list;

	public WarehouseSessionDetailResponse2() {
	}

	public WarehouseSessionDetailResponse2(List<WarehouseSessionDetailResponse> list) {
		this.total = list.size();
		this.list = list;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<WarehouseSessionDetailResponse> getList() {
		return list;
	}

	public void setList(List<WarehouseSessionDetailResponse> list) {
		this.list = list;
	}

}
