package one.wangwei.java;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ISO7064工具类
 * <p>
 * 使用ISO7064规范中定义的校验字符系统进行字符串的校验以及生成校验字符
 * </p>
 */
public class ISO7064Util {

    /**
     * ISO7064规范中定义的校验字符系统
     * <p>
     * <li>ISO 7064, MOD 11-2使用 {@link #ISO_7064_MOD_11_2}表示
     * </li>
     * <li>ISO 7064, MOD 37-2使用{@link #ISO_7064_MOD_37_2}表示</li>
     * <li>ISO 7064, MOD 97-10使用{@link #ISO_7064_MOD_97_10}
     * 表示</li>
     * <li>
     * ISO 7064, MOD 661-26使用 {@link #ISO_7064_MOD_661_26}表示
     * </li>
     * <li>ISO 7064, MOD 1271-36使用
     * {@link #ISO_7064_MOD_1271_36}表示</li>
     * <li>ISO 7064, MOD 11,10使用
     * {@link #ISO_7064_MOD_11_HYBRID_10}表示</li>
     * <li>ISO 7064, MOD 27,26使用
     * {@link #ISO_7064_MOD_27_HYBRID_26}表示</li>
     * <li>ISO 7064, MOD 37,36使用
     * {@link #ISO_7064_MOD_37_HYBRID_36}表示</li>
     */
    public enum Designation {
        /**
         * ISO 7064, MOD 11-2
         */
        ISO_7064_MOD_11_2,
        /**
         * ISO 7064, MOD 37-2
         */
        ISO_7064_MOD_37_2,
        /**
         * ISO 7064, MOD 97-10
         */
        ISO_7064_MOD_97_10,
        /**
         * ISO 7064, MOD 661-26
         */
        ISO_7064_MOD_661_26,
        /**
         * ISO 7064, MOD 1271-36
         */
        ISO_7064_MOD_1271_36,
        /**
         * ISO 7064, MOD 11,10
         */
        ISO_7064_MOD_11_HYBRID_10,
        /**
         * ISO 7064, MOD 27,26
         */
        ISO_7064_MOD_27_HYBRID_26,
        /**
         * ISO 7064, MOD 37,36
         */
        ISO_7064_MOD_37_HYBRID_36
    }

    /**
     * 计算校验字符
     *
     * @param withoutCheckCharacterString 不含校验字符的字符串
     * @param designation                 校验字符系统
     * @return 校验字符
     * @throws IllegalArgumentException 如果字符串不匹配对应校验字符系统的正则表达式
     */
    public static String computeCheckCharacter(
            String withoutCheckCharacterString, Designation designation) {
        // 检查字符串是否匹配对应校验字符系统的正则表达式
        if (!RegexMatcher.withoutCheckCharacterStringIsMatch(
                withoutCheckCharacterString, designation)) {
            throw new IllegalArgumentException();
        }
        // 计算校验字符
        return CheckCharacterComputor.compute(withoutCheckCharacterString,
                designation);
    }

    /**
     * 校验字符串
     *
     * @param withCheckCharacterString 含校验字符的字符串
     * @param designation              校验字符系统
     * @return true - 校验通过<br>
     * false-校验不通过
     * @throws IllegalArgumentException 如果字符串不匹配对应校验字符系统的正则表达式
     */
    public static boolean checkString(String withCheckCharacterString,
                                      Designation designation) {
        // 检查字符串是否匹配对应校验字符系统的正则表达式
        if (!RegexMatcher.withCheckCharacterStringIsMatch(
                withCheckCharacterString, designation)) {
            throw new IllegalArgumentException();
        }
        // 校验字符串
        return CheckCharacterSystemValidator.validate(withCheckCharacterString,
                designation);
    }

    /**
     * 正则表达式匹配器
     * <p>
     * 检查字符串是否匹配对应校验字符系统的正则表达式
     * </p>
     * <table border="1">
     * <tr>
     * <th>系统名称</th>
     * <th>适用范围</th>
     * <th>校验码数目及类型</th>
     * </tr>
     * <tr>
     * <td>ISO 7064, MOD 11-2</td>
     * <td>数字</td>
     * <td>1位数字或附加符X</td>
     * </tr>
     * <tr>
     * <td>ISO 7064, MOD 37-2</td>
     * <td>字母数字</td>
     * <td>1位数字或字母或附加符*</td>
     * </tr>
     * <tr>
     * <td>ISO 7064, MOD 97-10</td>
     * <td>数字</td>
     * <td>2位数字</td>
     * </tr>
     * <tr>
     * <td>ISO 7064, MOD 661-26</td>
     * <td>字母</td>
     * <td>2位字母</td>
     * </tr>
     * <tr>
     * <td>ISO 7064, MOD 1271-36</td>
     * <td>字母数字</td>
     * <td>2位数字或字母</td>
     * </tr>
     * <tr>
     * <td>ISO 7064, MOD 11,10</td>
     * <td>数字</td>
     * <td>1位数字</td>
     * </tr>
     * <tr>
     * <td>ISO 7064, MOD 27,26</td>
     * <td>字母</td>
     * <td>1位字母</td>
     * </tr>
     * <tr>
     * <td>ISO 7064, MOD 37,36</td>
     * <td>字母数字</td>
     * <td>1位数字或字母</td>
     * </tr>
     * </table>
     */
    private static class RegexMatcher {

        /**
         * 检查不含校验字符的字符串是否匹配对应校验字符系统的正则表达式
         *
         * @param withoutCheckCharacterString 不含校验字符的字符串
         * @param designation                 校验字符系统
         * @return true - 匹配<br>
         * false - 不匹配
         */
        static boolean withoutCheckCharacterStringIsMatch(
                String withoutCheckCharacterString, Designation designation) {
            return regexMatch(withoutCheckCharacterString,
                    REGEX_MAPPING_WITHOUT_CHECK_CHARACTER_STRING
                            .get(designation));
        }

        /**
         * 检查有校验字符的字符串是否匹配对应校验字符系统的正则表达式
         *
         * @param withCheckCharacterString 含校验字符的字符串
         * @param designation              校验字符系统
         * @return true - 匹配<br>
         * false - 不匹配
         */
        static boolean withCheckCharacterStringIsMatch(
                String withCheckCharacterString, Designation designation) {
            return regexMatch(withCheckCharacterString,
                    REGEX_MAPPING_WITH_CHECK_CHARACTER_STRING.get(designation));
        }

        /**
         * 数字正则表达式
         */
        static final String REGEX_NUMBERIC_STRINGS = "^[0-9]+$";
        /**
         * 含补充校验字符X的数字正则表达式
         */
        static final String REGEX_NUMBERIC_STRINGS_WITH_SUPPLEMENTARY_CHECK_CHARACTER = "^[0-9]+[0-9X]$";
        /**
         * 字母正则表达式
         */
        static final String REGEX_ALPHABETIC_STRINGS = "^[A-Z]+$";
        /**
         * 字母数字正则表达式
         */
        static final String REGEX_ALPHANUMBERIC_STRINGS = "^[0-9A-Z]+$";
        /**
         * 含补充校验字符*的字母数字表达式
         */
        static final String REGEX_ALPHANUMBERIC_STRINGS_WITH_SUPPLEMENTARY_CHECK_CHARACTER = "^[0-9A-Z]+[0-9A-Z*]$";

        /**
         * 校验字符系统对应的正则表达式（不含校验字符）
         */
        @SuppressWarnings("serial")
        static final Map<Designation, String> REGEX_MAPPING_WITHOUT_CHECK_CHARACTER_STRING = new HashMap<Designation, String>() {
            {
                put(Designation.ISO_7064_MOD_11_2, REGEX_NUMBERIC_STRINGS);
                put(Designation.ISO_7064_MOD_37_2, REGEX_ALPHANUMBERIC_STRINGS);
                put(Designation.ISO_7064_MOD_97_10, REGEX_NUMBERIC_STRINGS);
                put(Designation.ISO_7064_MOD_661_26, REGEX_ALPHABETIC_STRINGS);
                put(Designation.ISO_7064_MOD_1271_36,
                        REGEX_ALPHANUMBERIC_STRINGS);
                put(Designation.ISO_7064_MOD_11_HYBRID_10,
                        REGEX_NUMBERIC_STRINGS);
                put(Designation.ISO_7064_MOD_27_HYBRID_26,
                        REGEX_ALPHABETIC_STRINGS);
                put(Designation.ISO_7064_MOD_37_HYBRID_36,
                        REGEX_ALPHANUMBERIC_STRINGS);
            }
        };

        /**
         * 校验字符系统对应的正则表达式（含校验字符）
         */
        @SuppressWarnings("serial")
        static final Map<Designation, String> REGEX_MAPPING_WITH_CHECK_CHARACTER_STRING = new HashMap<Designation, String>() {
            {
                put(Designation.ISO_7064_MOD_11_2,
                        REGEX_NUMBERIC_STRINGS_WITH_SUPPLEMENTARY_CHECK_CHARACTER);
                put(Designation.ISO_7064_MOD_37_2,
                        REGEX_ALPHANUMBERIC_STRINGS_WITH_SUPPLEMENTARY_CHECK_CHARACTER);
                put(Designation.ISO_7064_MOD_97_10, REGEX_NUMBERIC_STRINGS);
                put(Designation.ISO_7064_MOD_661_26, REGEX_ALPHABETIC_STRINGS);
                put(Designation.ISO_7064_MOD_1271_36,
                        REGEX_ALPHANUMBERIC_STRINGS);
                put(Designation.ISO_7064_MOD_11_HYBRID_10,
                        REGEX_NUMBERIC_STRINGS);
                put(Designation.ISO_7064_MOD_27_HYBRID_26,
                        REGEX_ALPHABETIC_STRINGS);
                put(Designation.ISO_7064_MOD_37_HYBRID_36,
                        REGEX_ALPHANUMBERIC_STRINGS);
            }
        };

        static boolean regexMatch(String inputString, String regex) {
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(inputString);
            return matcher.matches();
        }
    }

    /**
     * 适用于数字的校验字符系统的数值对应表
     */
    private static final String[] NUMBERIC_STRINGS = {"0", "1", "2", "3", "4",
            "5", "6", "7", "8", "9", "X"};
    /**
     * 适用于字母的校验字符系统的数值对应表
     */
    private static final String[] ALPHABETIC_STRINGS = {"A", "B", "C", "D",
            "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q",
            "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    /**
     * 适用于字母数字的校验字符系统的数值对应表
     */
    private static final String[] ALPHANUMBERIC_STRINGS = {"0", "1", "2", "3",
            "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G",
            "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T",
            "U", "V", "W", "X", "Y", "Z", "*"};

    /**
     * 校验字符系统验证器
     */
    private static class CheckCharacterSystemValidator {
        static boolean validate(String inputString, Designation designation) {
            switch (designation) {
                case ISO_7064_MOD_11_2:
                case ISO_7064_MOD_37_2:
                case ISO_7064_MOD_97_10:
                case ISO_7064_MOD_661_26:
                case ISO_7064_MOD_1271_36:
                    return validatePureSystem(inputString, designation);
                case ISO_7064_MOD_11_HYBRID_10:
                case ISO_7064_MOD_27_HYBRID_26:
                case ISO_7064_MOD_37_HYBRID_36:
                    return validateHybridSystem(inputString, designation);
                default:
                    return false;
            }
        }

        /**
         * 纯系统校验
         */
        static boolean validatePureSystem(String inputString,
                                          Designation designation) {
            int M = 0; // 模数
            int r = 0; // 基数
            List<String> mapping = null;
            switch (designation) {
                case ISO_7064_MOD_11_2:
                    M = 11;
                    r = 2;
                    mapping = Arrays.asList(NUMBERIC_STRINGS);
                    break;
                case ISO_7064_MOD_37_2:
                    M = 37;
                    r = 2;
                    mapping = Arrays.asList(ALPHANUMBERIC_STRINGS);
                    break;
                case ISO_7064_MOD_97_10:
                    M = 97;
                    r = 10;
                    mapping = Arrays.asList(NUMBERIC_STRINGS);
                    break;
                case ISO_7064_MOD_661_26:
                    M = 661;
                    r = 26;
                    mapping = Arrays.asList(ALPHABETIC_STRINGS);
                    break;
                case ISO_7064_MOD_1271_36:
                    M = 1271;
                    r = 36;
                    mapping = Arrays.asList(ALPHANUMBERIC_STRINGS);
                    break;
                default:
                    return false;
            }
            char[] strArray = inputString.toCharArray();
            int S = 0;
            int n = strArray.length;
            for (int i = 1; i <= n; i++) {
                // 注意这里不要使用Math的pow方法
                S += mapping.indexOf(String.valueOf(strArray[i - 1]))
                        * BigInteger.valueOf(r).pow(n - i)
                        .mod(BigInteger.valueOf(M)).intValue();
            }
            return S % M == 1;
        }

        /**
         * 混合系统校验
         */
        static boolean validateHybridSystem(String inputString,
                                            Designation designation) {
            int M = 0; // 模数1
            List<String> mapping = null;

            switch (designation) {
                case ISO_7064_MOD_11_HYBRID_10:
                    M = 10;
                    mapping = Arrays.asList(NUMBERIC_STRINGS);
                    break;
                case ISO_7064_MOD_27_HYBRID_26:
                    M = 26;
                    mapping = Arrays.asList(ALPHABETIC_STRINGS);
                    break;
                case ISO_7064_MOD_37_HYBRID_36:
                    M = 36;
                    mapping = Arrays.asList(ALPHANUMBERIC_STRINGS);
                    break;
                default:
                    return false;
            }
            int Mplus1 = M + 1; // 模数2
            char[] strArray = inputString.toCharArray();
            int S = M + mapping.indexOf(String.valueOf(strArray[0]));
            int P = 0;
            for (int i = 1; i < strArray.length; i++) {
                P = ((S % M == 0 ? M : S % M) * 2) % Mplus1;
                S = P + mapping.indexOf(String.valueOf(strArray[i]));
            }
            return S % M == 1;
        }
    }

    /**
     * 校验字符生成器
     */
    private static class CheckCharacterComputor {
        static String compute(String inputString, Designation designation) {
            switch (designation) {
                case ISO_7064_MOD_11_2:
                case ISO_7064_MOD_37_2:
                    return polynomialMethod4PureSystemWith1CheckChar(
                            inputString, designation);
                case ISO_7064_MOD_97_10:
                case ISO_7064_MOD_661_26:
                case ISO_7064_MOD_1271_36:
                    return polynomialMethod4PureSystemWith2CheckChar(
                            inputString, designation);
                case ISO_7064_MOD_11_HYBRID_10:
                case ISO_7064_MOD_27_HYBRID_26:
                case ISO_7064_MOD_37_HYBRID_36:
                    return recursiveMethod4HybridSystemWith1CheckChar(
                            inputString, designation);
                default:
                    return null;
            }
        }

        /**
         * 通过多项式法计算纯系统一位校验字符
         */
        static String polynomialMethod4PureSystemWith1CheckChar(String str,
                                                                Designation designation) {
            int M = 0; // 模数
            int r = 0; // 基数
            List<String> mapping = null;
            switch (designation) {
                case ISO_7064_MOD_11_2:
                    M = 11;
                    r = 2;
                    mapping = Arrays.asList(NUMBERIC_STRINGS);
                    break;
                case ISO_7064_MOD_37_2:
                    M = 37;
                    r = 2;
                    mapping = Arrays.asList(ALPHANUMBERIC_STRINGS);
                    break;
                default:
                    break;
            }
            char[] strArray = str.toCharArray();
            int S = 0;
            int n = strArray.length + 1;
            for (int i = n; i >= 2; i--) {
                // 注意这里不要使用Math的pow方法
                S += mapping.indexOf(String.valueOf(strArray[n - i]))
                        * BigInteger.valueOf(r).pow(i - 1)
                        .mod(BigInteger.valueOf(M)).intValue();
            }
            return mapping.get((M + 1 - S % M) % M);
        }

        /**
         * 通过多项式法计算纯系统二位校验字符
         */
        static String polynomialMethod4PureSystemWith2CheckChar(String str,
                                                                Designation designation) {
            int M = 0; // 模数
            int r = 0; // 基数
            List<String> mapping = null;
            switch (designation) {
                case ISO_7064_MOD_97_10:
                    M = 97;
                    r = 10;
                    mapping = Arrays.asList(NUMBERIC_STRINGS);
                    break;
                case ISO_7064_MOD_661_26:
                    M = 661;
                    r = 26;
                    mapping = Arrays.asList(ALPHABETIC_STRINGS);
                    break;
                case ISO_7064_MOD_1271_36:
                    M = 1271;
                    r = 36;
                    mapping = Arrays.asList(ALPHANUMBERIC_STRINGS);
                    break;
                default:
                    break;
            }
            char[] strArray = str.toCharArray();
            int S = 0;
            int n = strArray.length + 2;
            for (int i = n; i >= 3; i--) {
                // 注意这里不要使用Math的pow方法
                S += mapping.indexOf(String.valueOf(strArray[n - i]))
                        * BigInteger.valueOf(r).pow(i - 1)
                        .mod(BigInteger.valueOf(M)).intValue();
            }
            return mapping.get(((M + 1 - S % M) % M) / r)
                    + mapping.get(((M + 1 - S % M) % M) % r);
        }

        /**
         * 通过递归法法计算混合系统一位校验字符
         */
        static String recursiveMethod4HybridSystemWith1CheckChar(
                String inputString, Designation designation) {
            int M = 0; // 模数1
            List<String> mapping = null;
            switch (designation) {
                case ISO_7064_MOD_11_HYBRID_10:
                    M = 10;
                    mapping = Arrays.asList(NUMBERIC_STRINGS);
                    break;
                case ISO_7064_MOD_27_HYBRID_26:
                    M = 26;
                    mapping = Arrays.asList(ALPHABETIC_STRINGS);
                    break;
                case ISO_7064_MOD_37_HYBRID_36:
                    M = 36;
                    mapping = Arrays.asList(ALPHANUMBERIC_STRINGS);
                    break;
                default:
                    break;
            }
            int Mplus1 = M + 1; // 模数2
            char[] strArray = inputString.toCharArray();
            int S = 0;
            int P = M;
            int n = strArray.length + 1;
            for (int i = n; i >= 2; i--) {
                S = P + mapping.indexOf(String.valueOf(strArray[n - i]));
                P = ((S % M == 0 ? M : S % M) * 2) % Mplus1;
            }
            return mapping.get((M + 1 - P % M) % M);
        }
    }
}