
let tbody = document.getElementById("tbody");


window.addEventListener(("load"), (e) => {
    getAllData();
})




function getAllData() {
    fetch("http://localhost:8080/employees").then(Response => {
        Response.json().then(data => {
            tbody.innerHTML = null;
            data.forEach(employee => {
                renderData(employee);
            })
        })
    })
    updateEmployee = document.getElementById("update");
}
function renderData(employee) {
    let tr = document.createElement("tr");
    tr.innerHTML = `
            <td>${employee.empId}</td>
            <td>${employee.empName}</td>
            <td>${employee.salary}</td>
            <td>${employee.department}</td>
            <td><button style ="background-color:#64DD17" onclick="updateRecord('${employee.empId}', '${employee.empName}', '${employee.salary}', '${employee.department}')">UPDATE</button> </td>
            <td><button style ="background-color:red" onclick="deleteRecord(${employee.empId})">DELETE</button> </td>
        `;
        tbody.append(tr);
}

let update = document.getElementById("update");
let submit = document.getElementById("submit");
let emp_Id = document.getElementById("empId");
let name = document.getElementById("name");
let salary = document.getElementById("salary");
let department = document.getElementById("department");
let searchById = document.getElementById("searchById");
let search = document.getElementById("Search");

function updateRecord(empId, empName, empSalary, empDept) {
    emp_Id.value = empId;
    name.value = empName;
    salary.value = empSalary;
    department.value = empDept;
    
}

update.addEventListener(("click"), (e) => {
    e.preventDefault();
    fetch("http://localhost:8080/employees/"+emp_Id.value, {
        method:"PUT",
        headers:{
            "content-type" : "application/json"
        },
        body:  JSON.stringify({
            "empName" : name.value,
            "salary":salary.value,
            "department":department.value
        })
    }).then(response => {
        
        if(response.status == 200 | response.status == 201) {
            alert("Employee credential updated successfully");
        }
        else {
            response.json().then(data => data.message);
        }
        location.reload()
    })
})


submit.addEventListener(("click"), (e) => {
    e.preventDefault();
    fetch("http://localhost:8080/employees", {
        method:"POST",
        headers:{"content-type":"application/json"},
        body: JSON.stringify({
            "empId" :emp_Id.value,
            "empName" : name.value,
            "salary":salary.value,
            "department":department.value
        })
    }).then(response => {
        if(response.status==200 | response.status == 201) {
            alert("Employee added successfully");
            location.reload();
        }
        else response.json().then(data => data.message);
    })
})

search.addEventListener(("click"), (e) => {
    fetch(`http://localhost:8080/employees/${searchById.value}`, 
    {
        method: "GET"
    }).then(res => {
        res.json().then(data => {
            tbody.innerHTML = null;
            renderData(data);
        })
    })
})


function deleteRecord(empId) {
    let choice = confirm("Are you sure you want to delete!");
    if(!choice) return;

    fetch("http://localhost:8080/employees/" + empId, {
        method : "DELETE"        
    }).then(Response => {
        if(Response.status == 200 | Response.status == 201) {
            
            alert("Employee deleted successfully!!")
            location.reload();
          
        }
        else Response.json().then(data => alert(data.message));
    })


}