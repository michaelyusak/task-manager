const tasksWrapper = document.getElementById("tasks-wrapper")

async function getTasks() {
    const url = "http://localhost:8080/api/v1/tasks"

    const response = await fetch(url)

    const responseData = await response.json()

    if (!response.ok) {
        throw new Error("failed to fetch tasks")
    }

    return responseData
}

async function getStatus() {
    const url = "http://localhost:8080/api/v1/status"

    const response = await fetch(url)

    const responseData = await response.json()

    if (!response.ok) {
        throw new Error("failed to fetch status")
    }

    return responseData
}

async function postActivity(activity) {
    const url = "http://localhost:8080/api/v1/tasks"

    const response = await fetch(url, {
        method: "POST",
        headers: {"Content-Type": "application/json"},
        body: activity
    })

    if (!response.ok) {
        throw new Error("failed to post task")
    }
}

async function putActivity(id, activity, statusId) {
    const url = `http://localhost:8080/api/v1/tasks/${id}`

    const response = await fetch(url, {
        method: "PUT",
        headers: {"Content-Type": "application/json"},
        body: JSON.stringify({
            activity: activity,
            statusId: statusId
        })
    })
}

function getStatusNameById(statusId, statusList) {
    let name = ""

    statusList.forEach(stat => {
        if (stat.id == statusId) {
            name = stat.statusName
        }
    })

    return name
}

function getStatusIdByName(statusName, statusList) {
    let id = 0

    statusList.forEach(stat => {
        if (stat.statusName == statusName) {
            id = stat.id
        }
    })

    return id
}

const saveEdittedActivityButton = document.getElementById("save-edited-activity")
const cancelEdittenActivityButton = document.getElementById("cancel-edited-activity")
const editActivityModal = document.getElementById("edit-activity-modal")
const editActivityTextarea = document.getElementById("edit-activity-textarea")

async function loadTask(statusList) {
    getTasks().then((tasks) => {
        tasks.forEach(task => {
            const taskDiv = document.createElement("div")
            const activity = document.createElement("p")
            const status = document.createElement("p")
            const editTask = document.createElement("button")
    
            const statusName = getStatusNameById(task.statusId, statusList)
    
            activity.textContent = task.activity
            status.textContent = statusName
            editTask.textContent = "edit"

            editTask.addEventListener("click", function () {
                editActivityModal.classList.remove("hidden")
                editActivityTextarea.value = task.activity
            })
    
            taskDiv.appendChild(activity)
            taskDiv.appendChild(status)
            taskDiv.appendChild(editTask)

            taskDiv.classList.add("task")
    
            tasksWrapper.appendChild(taskDiv)
        });
    })
}

getStatus().then((statusList) => {
    loadTask(statusList)
})

const newActivityButton = document.getElementById("new-activity-button")
const newActivityModal = document.getElementById("new-activity-modal")
const cancelNewActivity = document.getElementById("cancel-new-activity")
const saveNewActivity = document.getElementById("save-new-activity")
const newActivityTextarea = document.getElementById("new-activity-textarea")

newActivityButton.addEventListener("click", function () {
    newActivityModal.classList.remove("hidden")
})

cancelNewActivity.addEventListener("click", function () {
    newActivityModal.classList.add("hidden")
})

saveNewActivity.addEventListener("click", function () {
    postActivity(newActivityTextarea.value).then(() => {
        newActivityModal.classList.add("hidden")

        tasksWrapper.textContent = ""
        
        getStatus().then((statusList) => {
            loadTask(statusList)
        })
    })
})

cancelEdittenActivityButton.addEventListener("click", function () {
    editActivityModal.classList.add("hidden")
})
