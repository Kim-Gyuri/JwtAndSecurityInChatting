<#import "spring.ftl" as spring />

<#assign id = "">
<#assign pwd = "">

<#assign auth = .vars.auth>
<#assign headers = .vars.headers>

<#macro changeId event>
  <#assign id = event.target.value>
</#macro>

<#macro changePwd event>
  <#assign pwd = event.target.value>
</#macro>

<#macro login>
  <#assign req = {
    "email": id,
    "password": pwd
  }>

  <#assign url = 'http://localhost:8080/sign-in'>

  <#assign headers = {
    "Content-Type": "application/json"
  }>

  <#assign onSuccess = "handleLoginSuccess">

  <#assign errorCallback>
    <#macro errCallback response>
      <script>
        window.alert("${response?string}");
      </script>
    </#macro>
  </#assign>

  ${spring.ajax('POST', url, req, headers, onSuccess, errorCallback)}
</#macro>

<#macro handleLoginSuccess>
  <#macro handleLoginSuccess(response)>
    <#assign data = response?eval>

    <script>
      try {
        // 서버로부터 받은 데이터를 파싱하여 필요한 정보 추출
        const name = "${data.name?js_string}";
        const userLevel = "${data.userLevel?js_string}";
        const token = "${data.token?js_string}";

        // localStorage에 저장
        localStorage.setItem('name', name);
        localStorage.setItem('userLevel', userLevel);
        localStorage.setItem('token', token);

        // 로그인 성공 시 리디렉션
        window.location.href = '/chat/room';
      } catch (error) {
        console.log(error);
        window.alert('로그인에 실패했습니다.');
      }
    </script>
  </#macro>
</#macro>

<!DOCTYPE html>
<html>
<head>
  <title>Login</title>
</head>
<body>
  <div>
    <table class="table">
      <tbody>
        <tr>
          <th class="col-3">아이디</th>
          <td>
            <input type="text" value="${id}" onchange="changeId(event)" size="50px" />
          </td>
        </tr>

        <tr>
          <th>비밀번호</th>
          <td>
            <input type="password" value="${pwd}" onchange="changePwd(event)" size="50px" />
          </td>
        </tr>
      </tbody>
    </table><br />

    <div class="my-1 d-flex justify-content-center">
      <button class="btn btn-outline-secondary" onclick="login()"><i class="fas fa-sign-in-alt"></i> 로그인</button>
    </div>

  </div>
</body>
</html>
