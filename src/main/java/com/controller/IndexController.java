package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entity.Advice;
import com.entity.Article;
import com.entity.Banner;
import com.entity.Cate;
import com.entity.Complains;
import com.entity.Dept;
import com.entity.Doctor;
import com.entity.Orders;
import com.entity.Safes;
import com.entity.Users;
import com.service.AdviceService;
import com.service.ArticleService;
import com.service.BannerService;
import com.service.CateService;
import com.service.ComplainsService;
import com.service.DeptService;
import com.service.DoctorService;
import com.service.OrdersService;
import com.service.SafesService;
import com.service.UsersService;
import com.util.PageHelper;
import com.util.VeDate;

//定义为控制器
@Controller
// 设置路径
@RequestMapping("/index")
public class IndexController extends BaseController {

	@Autowired
	private DeptService deptService;
	@Autowired
	private SafesService safesService;
	@Autowired
	private DoctorService doctorService;
	@Autowired
	private UsersService usersService;
	@Autowired
	private CateService cateService;
	@Autowired
	private OrdersService ordersService;
	@Autowired
	private AdviceService adviceService;
	@Autowired
	private ComplainsService complainsService;
	@Autowired
	private BannerService bannerService;
	@Autowired
	private ArticleService articleService;

	// 公共方法 提供公共查询数据
	private void front() {
		this.getRequest().setAttribute("title", "医院挂号系统");
		List<Banner> bannerList = this.bannerService.getAllBanner();
		this.getRequest().setAttribute("bannerList", bannerList);
		List<Article> topList = this.articleService.getTopArticle();
		this.getRequest().setAttribute("topList", topList);
	}

	// 首页显示
	@RequestMapping("index.action")
	public String index() {
		this.front();
		List<Banner> bannerList = this.bannerService.getAllBanner();
		List<Banner> frontList = new ArrayList<Banner>();
		for (Banner banner : bannerList) {
			List<Article> articleList = this.articleService.getArticleByBanner(banner.getBannerid());
			banner.setArticleList(articleList);
			frontList.add(banner);
		}
		this.getRequest().setAttribute("frontList", frontList);
		List<Article> favList = this.articleService.getFlvArticle();
		this.getRequest().setAttribute("favList", favList);
		return "users/index";
	}

	// 新闻公告
	@RequestMapping("article.action")
	public String article(String id, String number) {
		this.front();
		Article article = new Article();
		article.setBannerid(id);
		List<Article> articleList = this.articleService.getArticleByCond(article);
		PageHelper.getIndexPage(articleList, "article", "article", id, 10, number, this.getRequest());
		Banner banner = this.bannerService.getBannerById(id);
		this.getRequest().setAttribute("banner", banner);
		return "users/article";
	}

	// 阅读公告
	@RequestMapping("read.action")
	public String read(String id) {
		this.front();
		Article article = this.articleService.getArticleById(id);
		article.setHits("" + (Integer.parseInt(article.getHits()) + 1));
		this.articleService.updateArticle(article);
		this.getRequest().setAttribute("article", article);
		return "users/read";
	}

	// 科室医生
	@RequestMapping("dept.action")
	public String dept(String number) {
		this.front();
		String id = this.getRequest().getParameter("id");
		Doctor doctor = new Doctor();
		doctor.setDeptid(id);
		List<Doctor> doctorList = this.doctorService.getDoctorByCond(doctor);
		PageHelper.getIndexPage(doctorList, "doctor", "dept", id, 12, number, this.getRequest());
		return "users/doctor";
	}

	// 全部医生
	@RequestMapping("doctor.action")
	public String doctor(String number) {
		this.front();
		List<Doctor> doctorList = this.doctorService.getAllDoctor();
		PageHelper.getIndexPage(doctorList, "doctor", "doctor", null, 12, number, this.getRequest());
		return "users/doctor";
	}

	// 医生详细
	@RequestMapping("doctorDetail.action")
	public String doctorDetail(String id) {
		this.front();
		Doctor doctor = this.doctorService.getDoctorById(id);
		this.getRequest().setAttribute("doctor", doctor);
		return "users/doctorDetail";
	}

	// 准备登录
	@RequestMapping("preLogin.action")
	public String prelogin() {
		this.front();
		return "users/login";
	}

	// 用户登录
	@RequestMapping("login.action")
	public String login() {
		this.front();
		String username = this.getRequest().getParameter("username");
		String password = this.getRequest().getParameter("password");
		Users u = new Users();
		u.setUsername(username);
		List<Users> usersList = this.usersService.getUsersByCond(u);
		if (usersList.size() == 0) {
			this.getSession().setAttribute("message", "用户名不存在");
			return "redirect:/index/preLogin.action";
		} else {
			Users users = usersList.get(0);
			if (password.equals(users.getPassword())) {
				this.getSession().setAttribute("userid", users.getUsersid());
				this.getSession().setAttribute("username", users.getUsername());
				this.getSession().setAttribute("users", users);
				return "redirect:/index/index.action";
			} else {
				this.getSession().setAttribute("message", "密码错误");
				return "redirect:/index/preLogin.action";
			}
		}
	}

	// 准备注册
	@RequestMapping("preReg.action")
	public String preReg() {
		this.front();
		List<Safes> safesList = this.safesService.getAllSafes();
		this.getRequest().setAttribute("safesList", safesList);
		return "users/register";
	}

	// 用户注册
	@RequestMapping("register.action")
	public String register(Users users) {
		this.front();
		Users u = new Users();
		u.setUsername(users.getUsername());
		List<Users> usersList = this.usersService.getUsersByCond(u);
		if (usersList.size() == 0) {
			users.setRegdate(VeDate.getStringDateShort());
			this.usersService.insertUsers(users);
		} else {
			this.getSession().setAttribute("message", "用户名已存在");
			return "redirect:/index/preReg.action";
		}

		return "redirect:/index/preLogin.action";
	}

	@RequestMapping("forget.action")
	public String forget() {
		this.front();
		return "users/forget";
	}

	@RequestMapping("step1.action")
	public String step1() {
		this.front();
		String username = this.getRequest().getParameter("username");
		Users u = new Users();
		u.setUsername(username);
		List<Users> usersList = this.usersService.getUsersByCond(u);
		if (usersList.size() == 0) {
			this.getSession().setAttribute("message", "用户名不存在");
			return "redirect:/index/preLogin.action";
		} else {
			Users x = usersList.get(0);
			String questions = x.getSafesname();
			this.getRequest().setAttribute("questions", questions);
			this.getRequest().setAttribute("username", username);
		}
		return "users/step1";
	}

	@RequestMapping("step2.action")
	public String step2() {
		this.front();
		String username = this.getRequest().getParameter("username");
		String answer = this.getRequest().getParameter("answer");
		Users u = new Users();
		u.setUsername(username);
		List<Users> usersList = this.usersService.getUsersByCond(u);
		Users x = usersList.get(0);
		if (x.getAnswer().equals(answer)) {
			this.getRequest().setAttribute("username", username);
			this.getRequest().setAttribute("password", x.getPassword());
		} else {
			this.getSession().setAttribute("message", "答案错误");
			return "redirect:/index/preLogin.action";
		}
		return "users/step2";
	}

	// 退出登录
	@RequestMapping("exit.action")
	public String exit() {
		this.front();
		this.getSession().removeAttribute("userid");
		this.getSession().removeAttribute("username");
		this.getSession().removeAttribute("users");
		return "redirect:/index/index.action";
	}

	// 准备修改密码
	@RequestMapping("prePwd.action")
	public String prePwd() {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		return "users/editpwd";
	}

	// 修改密码
	@RequestMapping("editpwd.action")
	public String editpwd() {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		String userid = (String) this.getSession().getAttribute("userid");
		String password = this.getRequest().getParameter("password");
		String repassword = this.getRequest().getParameter("repassword");
		Users users = this.usersService.getUsersById(userid);
		if (password.equals(users.getPassword())) {
			users.setPassword(repassword);
			this.usersService.updateUsers(users);
		} else {
			this.getSession().setAttribute("message", "旧密码错误");
			return "redirect:/index/prePwd.action";
		}
		this.getSession().setAttribute("message", "修改成功");
		return "redirect:/index/prePwd.action";
	}

	@RequestMapping("usercenter.action")
	public String usercenter() {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		return "users/usercenter";
	}

	@RequestMapping("userinfo.action")
	public String userinfo() {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		String userid = (String) this.getSession().getAttribute("userid");
		this.getSession().setAttribute("users", this.usersService.getUsersById(userid));
		return "users/userinfo";
	}

	@RequestMapping("personal.action")
	public String personal(Users users) {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		this.usersService.updateUsers(users);
		this.getSession().setAttribute("message", "修改成功");
		return "redirect:/index/userinfo.action";
	}

	// 准备挂号
	@RequestMapping("preOrders.action")
	public String preOrders(String doctorid) {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		List<Cate> cateList = this.cateService.getAllCate();
		List<Dept> deptList = this.deptService.getAllDept();
		this.getRequest().setAttribute("cateList", cateList);
		this.getRequest().setAttribute("deptList", deptList);
		this.getRequest().setAttribute("ordercode", "A" + VeDate.getStringId());
		return "users/addOrders";
	}

	// 挂号
	@RequestMapping("addOrders.action")
	public String addOrders(Orders orders) {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		String userid = (String) this.getSession().getAttribute("userid");
		Cate cate = this.cateService.getCateById(orders.getCateid());
		orders.setStatus("未付款");
		orders.setMoney(cate.getPrice());
		orders.setUsersid(userid);
		this.ordersService.insertOrders(orders);
		return "redirect:/index/myOrders.action";
	}

	// 我的挂号
	@RequestMapping("myOrders.action")
	public String myOrders() {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		String userid = (String) this.getSession().getAttribute("userid");
		Orders orders = new Orders();
		orders.setUsersid(userid);
		List<Orders> ordersList = this.ordersService.getOrdersByCond(orders);
		this.getRequest().setAttribute("ordersList", ordersList);
		return "users/myOrders";
	}

	@RequestMapping("detail.action")
	public String detail() {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		String id = this.getRequest().getParameter("id");
		Advice advice = new Advice();
		advice.setOrdersid(id);
		List<Advice> adviceList = this.adviceService.getAdviceByCond(advice);
		this.getRequest().setAttribute("adviceList", adviceList);
		return "users/myDetail";
	}

	// 准备付款
	@RequestMapping("prePay.action")
	public String prePay(String id) {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		this.getRequest().setAttribute("id", id);
		Orders orders = this.ordersService.getOrdersById(id);
		this.getRequest().setAttribute("orders", orders);
		return "users/pay";
	}

	// 付款
	@RequestMapping("pay.action")
	public String pay(String id) {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		Orders orders = this.ordersService.getOrdersById(this.getRequest().getParameter("id"));
		orders.setStatus("已付款");
		this.ordersService.updateOrders(orders);
		return "redirect:/index/myOrders.action";
	}

	@RequestMapping("preComplains.action")
	public String preComplains() {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		return "users/addComplains";
	}

	@RequestMapping("addComplains.action")
	public String addComplains(Complains complains) {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		String userid = (String) this.getSession().getAttribute("userid");
		complains.setAddtime(VeDate.getStringDateShort());
		complains.setStatus("未回复");
		complains.setUsersid(userid);
		this.complainsService.insertComplains(complains);
		return "redirect:/index/preComplains.action";
	}

	@RequestMapping("myComplains.action")
	public String myComplains(String number) {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		String userid = (String) this.getSession().getAttribute("userid");
		Complains complains = new Complains();
		complains.setUsersid(userid);
		List<Complains> complainsList = this.complainsService.getComplainsByCond(complains);
		PageHelper.getIndexPage(complainsList, "complains", "myComplains", null, 10, number, this.getRequest());
		return "users/myComplains";
	}

	@RequestMapping("myAdvice.action")
	public String myAdvice(String number) {
		this.front();
		if (this.getSession().getAttribute("userid") == null) {
			return "redirect:/index/preLogin.action";
		}
		Advice advice = new Advice();
		String userid = (String) this.getSession().getAttribute("userid");
		advice.setUsersid(userid);
		List<Advice> adviceList = this.adviceService.getAdviceByCond(advice);
		PageHelper.getIndexPage(adviceList, "advice", "myAdvice", null, 10, number, this.getRequest());
		return "users/myAdvice";
	}
}
