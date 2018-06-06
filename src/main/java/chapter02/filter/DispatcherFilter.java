package chapter02.filter;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import chapter02.action.SaveProductAction;
import chapter02.bean.Product;
import chapter02.form.ProductForm;

/**
 * use filter instead of servlet controller
 * @author mohan
 *
 */
/*@WebFilter(filterName = "DispatcherFilter", urlPatterns = "/*")*/
public class DispatcherFilter implements Filter {

	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		String uri = req.getRequestURI();
		int lastIndex = uri.lastIndexOf("/");
		String action = uri.substring(lastIndex + 1);
		String dispatchUrl = null;
		
		if ("input-product".equals(action)) {
			dispatchUrl = "/jsp/productForm.jsp";
		} else if ("save-product".equals(action)) {
			ProductForm productForm = new ProductForm();
			productForm.setName(request.getParameter("name"));
			productForm.setDescription(request.getParameter("description"));
			productForm.setPrice(request.getParameter("price"));
			
			Product product = new Product();
			product.setName(productForm.getName());
			product.setDescription(productForm.getDescription());
			product.setPrice(new BigDecimal(productForm.getPrice()));
			
			SaveProductAction saveProductAction = new SaveProductAction();
			saveProductAction.save(product);
			
			request.setAttribute("product", product);
			dispatchUrl = "/jsp/productDetail.jsp";
		}
		
		if (dispatchUrl != null) {
			RequestDispatcher rd = request.getRequestDispatcher(dispatchUrl);
			rd.forward(request, response);
		} else {
			filterChain.doFilter(request, response);
		}
	}

}
