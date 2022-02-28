<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<form class="col-sm-8 col-sm-offset-2" action="/account/login"
      method="post">
    <div class="row">
        <h2 style="text-align: center">Login with Social Media or
            Manually</h2>
        <b class="text-danger"><i>${message}${param.message}</i></b>
        <div class="vl">
            <span class="vl-innertext">or</span>
        </div>

        <div class="col form-group">
            <a href="/oauth2/authorization/facebook" class="fb btn nut"> <i
                    class="fa fa-facebook fa-fw"></i> Login with Facebook
            </a> <a href="/oauth2/authorization/google" class="google btn nut"><i
                class="fa fa-google fa-fw"> </i> Login with Google+ </a>
        </div>

        <div class="col form-group">
            <div class="hide-md-lg">
                <p>Or sign in manually:</p>
            </div>
            <input value="${form.username}" id="username" name="username"
                   value="${param.username }" placeholder="Username?"
                   class="form-control" required="required"> <input
                value="${form.password}" id="password" name="password"
                placeholder="Password?" type="password" class="form-control">


            <label class="checkbox-inline" for="remember-me"> <i
                    class="glyphicon glyphicon-save"></i> Remember? <input
                    name="remember-me" id="remember" type="checkbox">
            </label> <input type="hidden" name="${_csrf.parameterName}"
                            value="${_csrf.token}" /> <input type="submit" value="Login">
        </div>

    </div>
    <div class="bottom-container">
        <div class="row">

            <div class="col">
                <a href="#" style="color: white" class="btn">Sign up</a>
            </div>
            <div class="col">
                <a href="#" style="color: white" class="btn">Forgot password?</a>
            </div>
        </div>
    </div>
</form>