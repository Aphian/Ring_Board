/**
 * 문자열의 마지막(끝) 문자의 종성 포함 여부 확인
 * @param value - Target String
 * @returns 종성 포함 여부
 */
function hasCoda(value) {
    return ((value.charCodeAt(value.length - 1) - 0xAC00) % 28) > 0;
}


/**
 * 필드(Elemenet) 유효성 검사
 * @param target - 검사 대상 Element
 * @param fieldName - 필드명
 * @param focusTarget - 포커스 대상 Element
 * @returns 필드 입력(선택) 여부
 */
function isValid(target, fieldName, focusTarget) {
    if (target.value.trim()) {
        return true;
    }

    const particle = (hasCoda(fieldName)) ? '을' : '를'; // 조사
    const elementType = (target.type === 'text' || target.type === 'password' || target.type === 'search' || target.type === 'textarea') ? '입력' : '선택';
    alert( `${fieldName + particle} ${elementType}해 주세요.` );

    target.value = '';
    ( !focusTarget ? target : focusTarget).focus();
    throw new Error(`"${target.id}" is required...`)
}

function getJson(uri, params) {
	
	let json = {}
	
	$.ajax({
		url : uri,
		type : 'GET',
		dataType : 'json',
		data : params,
		async : false,
		success : function (response) {
			json = response;
		},
		
		error : function (request, status, error) {
			console.log(error)			
		}
	})
	
	return json;
	
}

function callApi(uri, method, params) {

    let json = {}

     $.ajax({
        url : uri,
        type : method,
        contentType : 'application/json; charset=utf-8',
        dataType : 'json',
        data : (params) ? JSON.stringify(params) : {},
        async : false,
        success : function (response) {
            json = response;
        },
        error : function (request, status, error) {
            console.log(error)
        }
    })

    return json;
}

