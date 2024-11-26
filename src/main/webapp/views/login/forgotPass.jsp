<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Forgot Password</title>
    <!-- Káº¿t ná»i vá»i file CSS bÃªn ngoÃ i -->
    <link href="styles.css" rel="stylesheet">
    <!-- Káº¿t ná»i vá»i Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container d-flex justify-content-center align-items-center vh-100">
        <div class="card custom-card">
            <div class="card-body">
                <h5 class="card-title text-center mb-4">Forgot your password?</h5>
                <p class="card-text text-center mb-4">Enter the email address associated with your account and we will send you a link to reset your password.</p>
                
                <form action="#" method="POST">
                    <div class="mb-3">
                        <label for="email" class="form-label">Email</label>
                        <input type="email" class="form-control" id="email" placeholder="Enter your email" required>
                    </div>
                    <button type="submit" class="btn btn-dark w-100">Reset my password</button>
                </form>
            </div>
        </div>
    </div>

    <!-- Káº¿t ná»i vá»i Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
