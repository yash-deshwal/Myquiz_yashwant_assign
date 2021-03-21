$(document).ready(function() { 
	init();

//connection to the main file which running on port 8086
	let base_url = 'http://localhost:8086/';
	let cont = $('#content');


	// ------------------------------------------------------------
	// Users

	// List of users
	//linked to the model class user for displaying the data
	$(document).on('click', '#users', function (e) {
		e.preventDefault();
		$('#sub-menu').html(getSubMenu('users'));
		let url = base_url+'users';

		$.ajax({
			url: url,
			method: 'GET',
			dataType: 'json',
			beforeSend: function () {
				cont.html('loading...');
			},
			complete: function () {},
			success: function success(data) {
				let contentHtml = '';
				if (data.length>0) {
					cont.removeClass().addClass("users");

					contentHtml += '<table>';
					contentHtml += '<tr><th>ID</th><th>Name</th><th>Address</th><th></th></tr>';
					data.forEach(function(el) {
						contentHtml += '<tr><td>'+ el.id +'</td>' +
							'<td>'+ el.name +'</td>' +
							'<td>'+ el.address +'</td>' +
							'<td><a href="#" id="deleteUser" idUser="'+el.id+'">Delete</a></td>' +
						'</tr>';
					});
					contentHtml += '</table>';
				}
				cont.html(contentHtml);

			},
			error: function error(jqXHR, textStatus, errorThrown) {
				console.log({ "jqXHR": jqXHR, "textStatus": textStatus, "errorThrown": errorThrown });
			}
		});

	});

	// add-user form
	//we can add new user from here
	$(document).on('click', '#addUserForm', function (e) {
		e.preventDefault();
		$('#sub-menu').html(getSubMenu('users'));

		let contentHtml = '';
		contentHtml += '<form id="userForm">';
			contentHtml += '<div>';
				contentHtml += '<lavel>ID </lavel>';
				contentHtml += '<input type="text" name="ID" value="">';
			contentHtml += '</div>';
			contentHtml += '<div>';
				contentHtml += '<lavel>Name </lavel>';
				contentHtml += '<input type="text" name="name" value="">';
			contentHtml += '</div>';
			contentHtml += '<div>';
				contentHtml += '<lavel>Address </lavel>';
				contentHtml += '<input type="text" name="address" value="">';
			contentHtml += '</div>';
		contentHtml += '<input type="button" id="addUser" name="addUser" value="Add">';
		contentHtml += '</form>';
		cont.html(contentHtml);

	});

	// add user
	$(document).on('click', '#addUser', function (e) {
		e.preventDefault();
		$('#sub-menu').html(getSubMenu('users'));
		let url = base_url+'users';

		let formData = {
			id : $('#userForm input[name=ID]').val(),
			name : $('#userForm input[name=name]').val(),
			address : $('#userForm input[name=address]').val()
		};

		$.ajax({
			url: url,
			method: 'POST',
			data: JSON.stringify(formData),
			contentType: 'application/json',
			beforeSend: function() {
				cont.html('loading...');
			},
			success: function success(data) {
				$('#users').trigger("click");
			},
			error: function error(jqXHR, textStatus, errorThrown) {
				console.log({ "jqXHR": jqXHR, "textStatus": textStatus, "errorThrown": errorThrown });
			}
		});

	});

	// delete User
	$(document).on('click', '#deleteUser', function (e) {
		e.preventDefault();
		$('#sub-menu').html(getSubMenu('users'));

		let url = base_url+'users/'+$(this).attr("idUser");

		$.ajax({
			url: url,
			method: 'DELETE',
			contentType: 'application/json',
			beforeSend: function() {
				cont.html('loading...');
			},
			complete: function () {
				$('#users').trigger("click");
			},
			success: function success(data) {},
			error: function error(jqXHR, textStatus, errorThrown) {
				console.log({ "jqXHR": jqXHR, "textStatus": textStatus, "errorThrown": errorThrown });
			}
		});

	});

	// Users
	// ============================================================



	// ------------------------------------------------------------
	// Questions
//linked to the model class question for displaying the data
	$(document).on('click', '#questions', function (e) {
		e.preventDefault();
		$('#sub-menu').html(getSubMenu('questions'));
		let url = base_url+'questions';

		$.ajax({
			url: url,
			method: 'GET',
			dataType: 'json',
			beforeSend: function () {
				cont.html('loading...');
			},
			complete: function () {},
			success: function success(data) {
				let contentHtml = '';

				if (data.results.length>0) {
					cont.removeClass().addClass("questions");

					contentHtml += '<table>';
					contentHtml += '<tr>' +
						'<th>Question</th>' +
						'<th>Correct answer</th>' +
						'<th>Incorrect answers</th>' +
						'<th>Category</th>' +
						'<th>Difficulty</th>' +
						'<th>Type</th>' +
					'</tr>';
					data.results.forEach(function(el) {
						contentHtml += '<tr>';
						contentHtml += '<td>'+ el.question +'</td>';
						contentHtml += '<td>'+ el.correct_answer +'</td>';
						contentHtml += '<td>';
						el.incorrect_answers.forEach(function (ia) {
							contentHtml += '<span>'+ia+'</span><br/>';
						});
						contentHtml += '</td>';
						contentHtml += '<td>'+ el.category +'</td>';
						contentHtml += '<td>'+ el.difficulty +'</td>';
						contentHtml += '<td>'+ el.type +'</td>';
						contentHtml += '</tr>';
					});
					contentHtml += '</table>';
				}

				cont.html(contentHtml);
			},
			error: function error(jqXHR, textStatus, errorThrown) {
				console.log({ "jqXHR": jqXHR, "textStatus": textStatus, "errorThrown": errorThrown });
			}
		});

	});

	// Questions
	// ============================================================




	// ------------------------------------------------------------
	// Quizzes
	//linked to the model class quiz for displaying the data

	$(document).on('click', '#quiz', function (e) {
		e.preventDefault();
		$('#sub-menu').html(getSubMenu('quiz'));
		let url = base_url+'quiz';

		$.ajax({
			url: url,
			method: 'GET',
			dataType: 'json',
			beforeSend: function () {
				cont.html('loading...');
			},
			complete: function () {},
			success: function success(data) {
				// console.log(data);
				let contentHtml = '';

				if (data.length>0) {
					cont.removeClass().addClass("quiz");

					contentHtml += '<table>';
					contentHtml += '<tr>' +
						'<th>Id</th>' +
						'<th>Start_date</th>' +
						'<th>Amount</th>' +
						'<th>User</th>' +
						'</tr>';
					data.forEach(function(el) {
						contentHtml += '<tr>';
						contentHtml += '<td>'+ el.id +'</td>';
						contentHtml += '<td>'+ el.start_date +'</td>';
						contentHtml += '<td>'+ el.amount +'</td>';
						contentHtml += '<td>';
							contentHtml += '<b>Id:</b> <span>'+el.user.id+'</span><br/>';
							contentHtml += '<b>Name:</b> <span>'+el.user.name+'</span><br/>';
							contentHtml += '<b>Address:</b> <span>'+el.user.address+'</span><br/>';
						contentHtml += '</td>';
						contentHtml += '</tr>';
					});
					contentHtml += '</table>';
				}

				cont.html(contentHtml);
			},
			error: function error(jqXHR, textStatus, errorThrown) {
				console.log({ "jqXHR": jqXHR, "textStatus": textStatus, "errorThrown": errorThrown });
			}
		});

	});

	// add-quiz form
	//try to do add quiz but can't make it...will try in break
	$(document).on('click', '#addQuizForm', function (e) {
		e.preventDefault();
		$('#sub-menu').html(getSubMenu('quiz'));

		let contentHtml = '';
		contentHtml += '<form id="userForm">';
		contentHtml += '</form>';
		cont.html(contentHtml);

	});





	// ------------------------------------------------------------
	// Tasks
	//linked to the model class task for displaying the data
	// extra feature

	$(document).on('click', '#tasks', function (e) {
		e.preventDefault();
		$('#sub-menu').html(getSubMenu('tasks'));
		let url = base_url+'tasks';

		$.ajax({
			url: url,
			method: 'GET',
			dataType: 'json',
			beforeSend: function () {
				cont.html('loading...');
			},
			complete: function () {},
			success: function success(data) {
				// console.log(data);
				let contentHtml = '';

				if (data.length>0) {
					cont.removeClass().addClass("tasks");

					contentHtml += '<table>';
					contentHtml += '<tr>' +
						'<th>Id</th>' +
						'<th>Text</th>' +
						'<th>Day</th>' +
						'<th>Reminder</th>' +
						'</tr>';
					data.forEach(function(el) {
						contentHtml += '<tr>';
						contentHtml += '<td>'+ el.id +'</td>';
						contentHtml += '<td>'+ el.text +'</td>';
						contentHtml += '<td>'+ el.day +'</td>';
						contentHtml += '<td>'+ el.reminder +'</td>';
						contentHtml += '</tr>';
					});
					contentHtml += '</table>';
				}

				cont.html(contentHtml);
			},
			error: function error(jqXHR, textStatus, errorThrown) {
				console.log({ "jqXHR": jqXHR, "textStatus": textStatus, "errorThrown": errorThrown });
			}
		});

	});

	// Tasks
	// ============================================================



	// ------------------------------------------------------------
	// My quiz
	//linked to the model class my quiz for displaying the data
	// list of quizes
	$(document).on('click', '#myquiz', function (e) {
		e.preventDefault();
		$('#sub-menu').html(getSubMenu('myquiz'));
		let url = base_url+'myquiz';

		$.ajax({
			url: url,
			method: 'GET',
			dataType: 'json',
			beforeSend: function () {
				cont.html('loading...');
			},
			complete: function () {},
			success: function success(data) {
				let contentHtml = '';

				if (data.length>0) {
					cont.removeClass().addClass("myquiz");

					contentHtml += '<table>';
					contentHtml += '<tr>' +
						'<th></th>' +
						'<th>Id</th>' +
						'<th>Amount</th>' +
						'<th>start_date</th>' +
						'<th>User</th>' +
						// '<th>Questions</th>' +
						'<th>Score</th>' +
						'</tr>';
					data.forEach(function(el) {
						contentHtml += '<tr>';
						contentHtml += '<td><a id="launchMyQuizForm" idQuiz="'+ el.id +'" idUser="'+el.user.id+'" href="#">Launch</a></td>';
						contentHtml += '<td>'+ el.id +'</td>';
						contentHtml += '<td>'+ el.amount +'</td>';
						contentHtml += '<td>'+ el.start_date +'</td>';
						contentHtml += '<td>';
							contentHtml += '<b>Id:</b> <span>'+el.user.id+'</span><br/>';
							contentHtml += '<b>Name:</b> <span>'+el.user.name+'</span><br/>';
							contentHtml += '<b>Address:</b> <span>'+el.user.address+'</span><br/>';
						contentHtml += '</td>';

						//contentHtml += '<td>';
						let amountCorrectQuestions = 0;
						el.questions.forEach( function (q, i) {
						//this part will display question and answer in advance if uncommented or i can change it shift his code to different page

							/*
							contentHtml += '<b>'+ q.question +'</b>';
							contentHtml += ' ('+ q.category +'; ';
							contentHtml += ''+ q.difficulty +'; ';
							contentHtml += ''+ q.type +') ';
							contentHtml += '<br/><b>'+ q.correct_answer +'</b>';
							contentHtml += ' (';
							q.answers.forEach(function (ia) {
								contentHtml += '<span>'+ia+'</span> | ';
							});
							contentHtml += ') ';
							contentHtml += '<br/><br/>';
							*/

							if (q.myAnswerCorrect !== null) {
								amountCorrectQuestions += q.myAnswerCorrect;
							}
						});
						//contentHtml += '</td>';

						contentHtml += '<td>';
						contentHtml += round((amountCorrectQuestions * 100)/el.questions.length, 2) + '%';
						contentHtml += '</td>';

						contentHtml += '</tr>';
					});

					contentHtml += '</table>';
				}

				cont.html(contentHtml);
			},
			error: function error(jqXHR, textStatus, errorThrown) {
				console.log({ "jqXHR": jqXHR, "textStatus": textStatus, "errorThrown": errorThrown });
			}
		});

	});

	// my quiz form
	//launch form function to attempt the quiz
	$(document).on('click', '#launchMyQuizForm', function (e) {
		e.preventDefault();
		$('#sub-menu').html(getSubMenu('myquiz'));

		let idQuiz = $(this).attr("idQuiz");
		let idUser = $(this).attr("idUser");


		let url = base_url+'myquiz/'+idQuiz;

		$.ajax({
			url: url,
			method: 'Get',
			dataType: 'json',
			beforeSend: function () {
				cont.html('loading...');
			},
			complete: function () {},
			success: function success(data) {
				console.log(data);
				let contentHtml = '';

				contentHtml += '<form id="myQuizForm">';
				contentHtml += '<input type="hidden" name="idUser" value="'+idUser+'">';
				contentHtml += '<input type="hidden" name="idQuiz" value="'+idQuiz+'">';

				data.questions.forEach( function (q) {
					contentHtml += '<div>';
					contentHtml += '<b>'+ q.question +' </b>';
						contentHtml += '<div>';
						q.answers.forEach(function (a, i) {
							contentHtml += '<label for="answer_'+q.id+'_'+i+'">'+a+'</label>';
							contentHtml += '<input type="radio" id="answer_'+q.id+'_'+i+'" questionId="'+q.id+'" name="question['+q.id+']" value="'+i+'">';
							contentHtml += ' | ';
						});
						contentHtml += '</div>';
					contentHtml += '</div><br/><br/>';
				});
				contentHtml += '<input type="button" id="storeMyQuiz" name="storeMyQuiz" value="Store my quiz">';
				contentHtml += '</form>';
				cont.html(contentHtml);
			},

			error: function error(jqXHR, textStatus, errorThrown) {
				console.log({ "jqXHR": jqXHR, "textStatus": textStatus, "errorThrown": errorThrown });
			}
		});

	});

	// store quiz answers from user
	$(document).on('click', '#storeMyQuiz', function (e) {
		e.preventDefault();
		$('#sub-menu').html(getSubMenu('myquiz'));
		let url = base_url+'myquiz';

		let answers = [];
		$('#myQuizForm input[type=radio]:checked').each(function (i) {
			answers.push(
				{
					questionId: $(this).attr("questionId"),
					answer: $(this).val()
				}
			);

		});
		//console.log(answers);

		let formData = {
			userId : $('#myQuizForm input[name=idUser]').val(),
			quizId : $('#myQuizForm input[name=idQuiz]').val(),
			answers : answers
		};
		// console.log(formData);

		$.ajax({
			url: url,
			method: 'PUT',
			data: JSON.stringify(formData),
			contentType: 'application/json',
			beforeSend: function() {
				cont.html('loading...');
			},
			success: function success(data) {
				$('#myquiz').trigger("click");
			},
			error: function error(jqXHR, textStatus, errorThrown) {
				console.log({ "jqXHR": jqXHR, "textStatus": textStatus, "errorThrown": errorThrown });
			}
		});


	});

	// My quiz
	// ============================================================


});



function init() {
}


// try to made submenu for others too but for now only created for users
function getSubMenu(topMenu='') {
	let subMenuHtml = '';
	switch (topMenu) {
		case "users":
			subMenuHtml += '<a id="users" href="#">List of users</a> | ';
			subMenuHtml += '<a id="addUserForm" href="#">Add user</a>';
			break;
		case "questions":

			break;
		case "quiz":

			break;
		case "tasks":

			break;
		case "myquiz":

			break;
		default:
			subMenuHtml = '';
	}
	return subMenuHtml;
}

// for giving the score percentage
function round(num, decimalPlaces = 0) {
	num = Math.round(num + "e" + decimalPlaces);
	return Number(num + "e" + -decimalPlaces);
}

