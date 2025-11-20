<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html xmlns="http://www.w3.org/1999/xhtml" lang="ko">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script type="text/javaScript">
    
    function requestNumberInput() {
    	  // AJAX 또는 REST API로 앱에 숫자 입력 요청 이벤트 전송
    	  fetch('/api/push-num-input', {
    	    method: 'POST',
    	    headers: {'Content-Type': 'application/json'},
    	    body: JSON.stringify({number: document.getElementById('numberView').innerText})
    	  })
    	  .then(res => res.json())
    	  .then(data => alert('앱에 숫자 입력 팝업 요청 완료!'));
    	}
    
    </script>
</head>
<body>
</body>
<div>
  <span id="numberView">25</span>
  <button onclick="requestNumberInput()">숫자 입력 요청</button>
  
  <script type="module">
  
  import { initializeApp } from "https://www.gstatic.com/firebasejs/12.6.0/firebase-app.js";
  import { getAnalytics } from "https://www.gstatic.com/firebasejs/12.6.0/firebase-analytics.js";
   
  async function initFirebase() {

      // 서버에 있는 firebase-key.json 가져오기
      const response = await fetch("<%=request.getContextPath()%>/firebase-key");
      const firebaseConfig = await response.json();

      // 가져온 설정으로 Firebase 초기화
      const app = initializeApp(firebaseConfig);
      const analytics = getAnalytics(app);

      console.log("Firebase initialized:", app);
  }

  // 실행
  initFirebase();
</script>
</div>
</html>    