

https://user-images.githubusercontent.com/100904133/198803410-34446f2d-0261-4cd6-9fa7-60c0c24fdbbd.MP4

# mobileProgramming
### 로그인 화면 (Relative Layout 사용)

자동로그인시, SharedPreferences에 저장된 값 읽음
로그인, 회원가입, product 버튼 구현

로그인 성공하고 자동로그인 true인 경우 SharedPreferences에 값 저장

### 회원가입 화면 (Linear Layout 사용)
빈칸 있는 경우, 존재하는 아이디의 경우, 비밀번호 규칙(5자 이상, 숫자, 특수문자 사용) 중 하나라도 맞지 않으면 Toast 띄움
회원가입 성공 시, files에 id, password, name, phone, address 저장

### Product 화면(Grid Layout 사용)
로그인 했을 경우 -> 회원정보 클릭 시 Info 화면으로 넘어감
로그인 하지 않았을 경우 -> 회원정보 클릭 시 Dialog 띄우고 회원가입 화면으로 넘어감

### Info 화면(Linear Layout 사용)
회원이 이름, 전화번호, 주소 보여줌


**1. 첫번째 화면 (Relative Layout 혹은 Fragment 사용) - 5점**- 
앱 접속 페이지

회원 ID/비밀번호(EditView)

로그인/회원가입(Button)

- 첫번째 화면 초기화시에 기존에 저장된 개인정보 읽어 오기

- ID, 비밀번호 입력 시 기존에 가입한 회원 ID, 비밀번호 체크 오류 시 에러 메시지 출력

- ID, 비밀번호 입력이 정상이고 로그인 버튼 클릭 시 세번째 페이지 이동

- 회원가입 없이도 메인 버튼(상품 출력 페이지)을 클릭하면 세번째 화면으로 이동 가능

**2. 두번째 화면 (Linear Layout 혹은 Fragment 사용) - 5점**

- 회원가입 페이지, 첫번째 페이지에서 회원가입 버튼 클릭 시 출력

- ID(EditView, 중복검사), @비밀번호(EditView, 자릿수/특수키 등 규칙 체크)

- 이름/전화번호/주소(EditView)

- 개인정보 사용 동의 간략 약관(TextView), 동의 여부(Radio Button, Decline/Accept)

- 회원정보를 저장하고 첫번째 페이지로 이동   

(선택) 회원정보 저장은 전역변수, 프레퍼런스(Preference), 파일을 활용

**3. 세번째 화면 (Constraint Layout, Table Layout, Grid Layout, Frame Layout 중 하나 사용) - 5점**

- 상품명, 상품이미지 리스트를 보여주는 화면 (5개이상 이미지를 기본으로 출력)  

(선택) 화면 아래 부분에서 상품명, 상품이미지를 등록 및 삭제하는 버튼 추가

- 화면 아래 부분에 회원정보 버튼은 회원인 경우는 가입한 회원 정보를 보여주고  회원이 아닌 경우는 회원정보 버튼을 클릭하면 회원가입 여부를 물어보고  원하면 회원가입 페이지인 두번째 화면으로 이동 **(유저관리 - 5점)**

- View을 상속한 여러가지 위젯을 사용하여 화면을 구성(기능에 맞는 위젯 선택하여 구성)  View Group을 상속한 위젯 ListView, GridView, AdapterView, ToolBar 등  Text View을 상속한 CheckBox, Switch, ToggleButton, RadioButton 등  ImageView, ImageButton 등

- 과제 제출시에는 이캠퍼스 개인과제 제출 페이지에서 구현내용과 실행환경(Readme.txt 파일)을 자세하게 설명하고 소스 파일은 압축(ZIP)하여 등록Readme.txt 파일에는 SDK 버전(Android 버전 12)을 기재하고  구현된 기능을 간략하게 설명하고 그외 앱 실행 환경 및 참고할 내용이 있다면 기재
- 각페이지 구성시에 View을 상속한 여러가지 위젯을 사용하여 화면을 구성 (기능에 맞는 위젯 선택하여 구성) ListView, GridView, AdapterView, ToolBar, Text View, CheckBox, Switch,  ToggleButton, RadioButton, ImageView, ImageButton 등
- 과제 제출이캠퍼스 과제 공지 게시판에 구현내용(Readme 파일) 및 소스 파일은 압축(ZIP)하여 등록 * 소스파일은 깃허브에 등록한 경우는 주소 기재 가능함
