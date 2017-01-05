import java.util.List;

import test.product.dao.ProductDao;
import test.product.dto.ProductDto;

public class test {
	public static void main(String[] args) {
	
		List<ProductDto> list = ProductDao.getInstance().getRankedViewCount();
		
		for(ProductDto tmp : list){
			System.out.println(tmp.getBrand());
		}
	}
}
