#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

string addStr(string a, string b) {
    string res = "";
    int carry = 0;
    int i = a.length() - 1, j = b.length() - 1;
    while (i >= 0 || j >= 0 || carry) {
        int sum = carry;
        if (i >= 0) sum += a[i--] - '0';
        if (j >= 0) sum += b[j--] - '0';
        res += to_string(sum % 10);
        carry = sum / 10;
    }
    reverse(res.begin(), res.end());
    return res;
}

string mul8(string a) {
    string res = "";
    int carry = 0;
    for (int i = a.length() - 1; i >= 0; i--) {
        int prod = (a[i] - '0') * 8 + carry;
        res += to_string(prod % 10);
        carry = prod / 10;
    }
    if (carry) res += to_string(carry);
    reverse(res.begin(), res.end());
    return res;
}

int main() {
    int n;
    if (cin >> n) {
        if (n == 0) { 
            cout << 1 << endl; 
            return 0; 
        }
        string e = "1";
        string p10 = "1";
        for (int i = 1; i <= n; i++) {
            string next_e = addStr(mul8(e), p10);
            e = next_e;
            p10 += "0";
        }
        cout << e << endl;
    }
    return 0;
}
