@echo off
@title bat 交互执行git命令
echo.
echo ====开始执行====
echo.
git status
echo.
echo ====将本地修改文件全部添加到暂存区====
echo.
git add -A
echo.
echo ====提交暂存区文件到本地仓库====
echo.
git commit -m %date:~0,4%年%date:~5,2%月%date:~8,2%日
echo.
echo ====拉取远程分支内容到当前分支====
echo.
git pull origin master
echo.
echo ====提交本地仓库修改文件到远程====
echo.
git push -u origin master
echo.
echo ====完成操作====
echo.
pause