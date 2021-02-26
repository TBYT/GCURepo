@include('layouts.header')
<html lang="en">
<head>
    <title>@yield('title')</title>
</head>
<body>
    <div align="center">
        @yield('content')
    </div>
</body>
</html>
@include('layouts.footer')
